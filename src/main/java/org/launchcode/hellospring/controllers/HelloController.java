package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
// @ResponseBody // to apply this annotation to the entire class
@RequestMapping(value = "hey") // this is pre path!!
public class HelloController {

    // response to GET requests to the root path: /
    @GetMapping("")
    @ResponseBody // optional to give a raw body of the method
    public String hello() {
        return "Hello, Spring!";
    }

    // another option to map requests
//    @RequestMapping(value = "bonjour", method = RequestMethod.GET)
    @GetMapping("bonjour")
    @ResponseBody
    public String bonjour() {
        return "Bonjour, Spring!";
    }

    // responds to requests like /hello?name=nameVariable from args
    @GetMapping("hello")
    @ResponseBody
    public String helloQuery(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // responds to requests like /hi/variable from args
    @GetMapping("hi/{name}")
    @ResponseBody
    public String hiQuery(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("hello-forms")
    @ResponseBody
    public String helloForms() {
        return "<form method='POST'>" +
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                "<option value='0' default>English</option>" +
                "<option value='1'>Russian</option>" +
                "<option value='2'>French</option>" +
                "<option value='3'>German</option>" +
                "<option value='4'>Italian</option>" +
                "</select>" +
                "<button type='submit'>Send</button>" +
                "</form>";
    }

    // POST method response
    @PostMapping("hello-forms")
    @ResponseBody
    public String createMessage(@RequestParam String name, int language) { // parameters from the client request;
        String hello = "Hello";
        switch (language) {
            case 1:
                hello = "Привет";
                break;
            case 2:
                hello = "Bonjour";
                break;
            case 3:
                hello = "Hallo";
                break;
            case 4:
                hello = "Ciao";
                break;
        }

        return "<h1 style='text-align: center;'>" +
                "" + hello + ", " + name + "!" +
                "</h1>";
    }
}
