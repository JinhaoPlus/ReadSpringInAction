package top.jinhaoplus.spittr.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import top.jinhaoplus.spittr.web.controller.HomeController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class HomeControllerTest {

    @Test
    public void testHomePage() throws Exception {
        HomeController controller = new HomeController();
        // 使用Mock出的MVC模拟一个Web Container来发起模拟请求
        // 使用standaloneSetup来测试一个独立的Controller组件
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/"))
                .andExpect(view().name("home"));
    }

}
