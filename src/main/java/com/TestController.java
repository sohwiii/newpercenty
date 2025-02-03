package com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@Controller
public class TestController {
	
    @ResponseBody
    @RequestMapping(value="/home.do")
    public String sampleHome() {
        return "Hello World!";
    }
    
    @GetMapping("/hell")
    public String hello (Model model) {
        model.addAttribute("data", "hello!");
        return "hello";
    }
    
    @RequestMapping(value="/login.do")
    public static void login() {
    	System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

        // ChromeDriver 객체 생성
        WebDriver driver = new ChromeDriver();

        try {
            // 사이트 접속 (예시: 로그인 페이지)
            driver.get("https://www.percenty.co.kr/signin");

            // 로그인 폼에 해당하는 요소를 찾기 (이메일과 비밀번호 입력란, 로그인 버튼)
            WebElement username = driver.findElement(By.cssSelector("input[placeholder='이메일 주소 입력']"));
            WebElement password = driver.findElement(By.cssSelector("input[placeholder='영문/숫자/특수문자의 조합 (6~15자리)']"));
            WebElement loginButton = driver.findElement(By.xpath("//button[span[text()='로그인 하기']]"));

            // 로그인 정보 입력
            username.sendKeys("sohwe124@gmail.com");
            password.sendKeys("sh980519!@");

            // 로그인 버튼 클릭
            loginButton.click();

            // 로그인 후 페이지 이동 또는 다른 작업을 할 수 있음
            System.out.println("로그인 성공");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
