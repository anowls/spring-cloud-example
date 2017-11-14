package com.hanboard.educloud.account.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanboard.educloud.account.common.AbstractTestCaseSupport;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest extends AbstractTestCaseSupport {

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void getUsers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/users")
                .param("page", "0")
                .param("size", "10")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("小明")))
                .andExpect(content().string(containsString("系统管理员")))
        .andDo(print());
    }
//
//    @Test
//    public void getUser() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/users/{id}", "hhhhhh")
//                .accept(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("hhhhhh")));
//    }
//
//    @Test
//    public void getUserByIdParam() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/users/param?id={id}", "2333333")
//                .accept(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("2333333")));
//    }
//
//    @Test
//    public void deleteUser() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.delete("/users/123")
//                .accept(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("删除成功")));
//    }
//
//    @Test
//    public void batchDeleteUser() throws Exception {
//        List<String> ids = new ArrayList<>();
//        ids.add("123");
//        ids.add("456");
//        ids.add("abc");
//        mvc.perform(MockMvcRequestBuilders.delete("/users")
//                .accept(MediaType.APPLICATION_JSON_UTF8)
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .content(mapper.writeValueAsString(ids)))
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("删除成功")));
//
//    }
//
//    @Test
//    public void updateUser() throws Exception {
//        User user = new User();
//        user.setId("abc");
//        user.setAge(12);
//        user.setUsername("小明");
//        mvc.perform(MockMvcRequestBuilders.put("/users/123")
//                .accept(MediaType.APPLICATION_JSON_UTF8)
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .content(mapper.writeValueAsString(user)))
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("123")));
//
//        mvc.perform(MockMvcRequestBuilders.patch("/users/abc333")
//                .accept(MediaType.APPLICATION_JSON_UTF8)
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .content(mapper.writeValueAsString(user)))
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("abc333")));
//    }
//
//    @Test
//    public void saveUser() throws Exception {
//        User user = new User();
//        user.setAge(12);
//        user.setUsername("小明");
//        user.setPassword("password");
//        mvc.perform(MockMvcRequestBuilders.post("/users")
//                .accept(MediaType.APPLICATION_JSON_UTF8)
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .content(mapper.writeValueAsString(user)))
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("小明")))
//                .andExpect(content().string(containsString("password")));
//    }

    @Test
    public void test() {

    }

}
