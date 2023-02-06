package hello.spring_start.controller;

import org.apache.tomcat.util.net.TLSClientHelloExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {

    // 정적컨텐츠 방식
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    // MVC 방식
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model){
        model.addAttribute("name", name);
        return "hello-templates";
    }

    //API 방식
    @GetMapping("hello-string")
    @ResponseBody // 응답 body에 data를 직접 넣어주겠다
    public String helloString(@RequestParam(value = "name", required = false) String name){
        return "hello" + name;
    }
    @GetMapping("hello-api")
    @ResponseBody // 응답 body에 data를 직접 넣어주겠다
    public Hello helloApi(@RequestParam(value = "name", required = false) String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello{
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}
