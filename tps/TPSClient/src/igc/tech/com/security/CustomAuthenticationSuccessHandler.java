package igc.tech.com.security;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import igc.tech.com.dao.UserDetailDao;
import igc.tech.com.mapper.UserDetailMapper;
import igc.tech.com.model.UserDetailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
 
public class CustomAuthenticationSuccessHandler implements
		AuthenticationSuccessHandler {

	@Autowired
	UserDetailDao userDetailDao;
 
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
		HttpSession session = request.getSession();

		UserDetailModel userDetailModel= new UserDetailModel();
		userDetailModel.setEmailId(authentication.getName());

		userDetailModel = new UserDetailMapper().mapRow((Map) userDetailDao.procUserDetail(userDetailModel,null,"s").get(0));

		/*Set some session variables*/
//		User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		/*session.setAttribute("role",authentication.getAuthorities());
		session.setAttribute("userName", authentication.getName());*/

		session.setAttribute("userDetailId",userDetailModel.getUserDetailId());
		session.setAttribute("roleId",userDetailModel.getRoleId());
		session.setAttribute("userName", authentication.getName());
        session.setAttribute("role", authentication.getAuthorities());
        
        /*Set target URL to redirect*/
		String targetUrl = determineTargetUrl(authentication,session, userDetailModel);
        redirectStrategy.sendRedirect(request, response, targetUrl);
	}
 
	protected String determineTargetUrl(Authentication authentication, HttpSession session, UserDetailModel userDetailModel) {
        Set<String> authorities = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (authorities.contains("REGISTER")) {
        	return "/register/checkToken/"+session.getAttribute("token");
        } else {
			if(userDetailModel.getAddress()==null || userDetailModel.getPhoneNo() == null){
				return "/completeUserDetail";
			}else if(userDetailModel.getAddress().isEmpty() || userDetailModel.getPhoneNo().isEmpty()){
				return "/completeUserDetail";
			}else{
				return "/";
			}

        }
    }
 
	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}
 
	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}
}