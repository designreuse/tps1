package igc.tech.com.interceptors;

import igc.tech.com.dao.MenuAccessDao;
import igc.tech.com.mapper.MenuAccessMapper;
import igc.tech.com.mapper.MenuMapper;
import igc.tech.com.model.MenuAccessModel;
import igc.tech.com.model.MenuAccessModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Ganga on 9/12/2016.
 */
public class MenuInterceptors implements HandlerInterceptor {

    @Autowired
    MenuAccessDao menuAccessDao;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse,
                             Object o) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        HttpSession session = httpServletRequest.getSession();

        MenuAccessModel menuAccessModel = new MenuAccessModel();
        menuAccessModel.setRoleId(session.getAttribute("roleId").toString());
        List<MenuAccessModel> menuAccessModelList = new MenuAccessMapper().mapList(menuAccessDao.procMenuAccess(menuAccessModel,null,"m"));
//        System.out.println("menu Access "+menuAccessModelList);
          modelAndView.addObject("nav", menuAccessModelList);

        menuAccessModelList = new MenuAccessMapper().mapList(menuAccessDao.procMenuAccess(menuAccessModel,null,"t"));
        modelAndView.addObject("topNav", menuAccessModelList);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
