package igc.tech.com.security;

import igc.tech.com.dao.MenuDao;
import igc.tech.com.model.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyFilterSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

@Autowired
MenuDao menuDao;

    @Override
    public List<ConfigAttribute> getAttributes(Object object) {
        System.out.println("getAttribute");
        System.out.println("object"+object);
        FilterInvocation fi = (FilterInvocation) object;
        String url = fi.getRequestUrl();
        List<ConfigAttribute> attributes = new ArrayList<ConfigAttribute>();
        attributes.add(new SecurityConfig("ROLE_SUPERADMIN"));


            String subUrl = url.substring(url.indexOf("/"),url.indexOf("/", url.indexOf("/") + 1)+1)+"%";
        System.out.println("subUrl: "+subUrl);

            MenuModel menuModel = new MenuModel();
            menuModel.setMenuUrl(subUrl);
            List list = menuDao.procMenu(menuModel,null,"v");
            System.out.println(list);

            for(int i=0; i< list.size();i++){
                Map map = (Map) list.get(i);
                attributes.add(new SecurityConfig(map.get("role_desc").toString()));
            }

        return attributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {



        /*System.out.println("hello");
        String[] roles = new String[] {"ROLE_ADMIN"};

        return SecurityConfig.createList(roles);*/
        return null;

    }

    @Override
    public boolean supports(Class<?> clazz) {


        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}