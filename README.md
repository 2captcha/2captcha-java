# JAVA Module for 2Captcha API
The easiest way to quickly integrate [2Captcha] into your code to automate solving of any types of captcha.

- [Installation](#installation)
- [Configuration](#configuration)
- [Basic example](#basic-example)
- [Supported captcha types](#supported-captcha-types)
  - [Normal Captcha](#normal-captcha)
  - [Text](#text-captcha)
  - [ReCaptcha v2](#recaptcha-v2)
  - [ReCaptcha v3](#recaptcha-v3)
  - [FunCaptcha](#funcaptcha)
  - [GeeTest](#geetest)
  - [hCaptcha](#hcaptcha)
  - [KeyCaptcha](#keycaptcha)
  - [Capy](#capy)
  - [Grid (ReCaptcha V2 Old Method)](#grid)
  - [Canvas](#canvas)
  - [ClickCaptcha](#clickcaptcha)
  - [Rotate](#rotate)
- [Other methods](#other-methods)
  - [send / getResult](#send--getresult)
  - [balance](#balance)
  - [report](#report)
- [Error handling](#error-handling)


## Installation
Maven repo: TODO

## Configuration
`TwoCaptcha` instance can be created like this:
```java
TwoCaptcha solver = new TwoCaptcha('YOUR_API_KEY');
```
Also there are few options that can be configured:
```java
solver.setSoftId(123);
solver.setCallback("https://your.site/result-receiver");
solver.setDefaultTimeout(120);
solver.setRecaptchaTimeout(600);
solver.setPollingInterval(10);
```

## Basic example
Example below shows how to solve simple captcha image. Check out `src/main/java/examples` directory to find more examples with all available options and captchas.
```java
Normal captcha = new Normal();
captcha.setFile("path/to/captcha.jpg");
captcha.setMinLen(4);
captcha.setMaxLen(20);
captcha.setCaseSensitive(true);
captcha.setLang("en");

try {
    solver.solve(captcha);
    System.out.println("Captcha solved: " + captcha.getCode());
} catch (Exception e) {
    System.out.println("Error occurred: " + e.getMessage());
}
```

## Supported captcha types

### Normal Captcha
```java
Normal captcha = new Normal();
captcha.setFile("path/to/captcha.jpg");
captcha.setNumeric(4);
captcha.setMinLen(4);
captcha.setMaxLen(20);
captcha.setPhrase(true);
captcha.setCaseSensitive(true);
captcha.setCalc(false);
captcha.setLang("en");
captcha.setHintImg(new File("path/to/hint.jpg"));
captcha.setHintText("Type red symbols only");
```

### Text Captcha
```java
Text captcha = new Text();
captcha.setText("If tomorrow is Saturday, what day is today?");
captcha.setLang("en");
```

### ReCaptcha v2
```java
ReCaptcha captcha = new ReCaptcha();
captcha.setSiteKey("6Le-wvkSVVABCPBMRTvw0Q4Muexq1bi0DJwx_mJ-");
captcha.setUrl("https://mysite.com/page/with/recaptcha");
captcha.setInvisible(true);
captcha.setAction("verify");
captcha.setProxy("HTTPS", "login:password@IP_address:PORT");
```
### ReCaptcha v3
```java
ReCaptcha captcha = new ReCaptcha();
captcha.setSiteKey("6Le-wvkSVVABCPBMRTvw0Q4Muexq1bi0DJwx_mJ-");
captcha.setUrl("https://mysite.com/page/with/recaptcha");
captcha.setVersion("v3");
captcha.setAction("verify");
captcha.setScore(0.3);
captcha.setProxy("HTTPS", "login:password@IP_address:PORT");
```

### FunCaptcha
```java
FunCaptcha captcha = new FunCaptcha();
captcha.setSiteKey("69A21A01-CC7B-B9C6-0F9A-E7FA06677FFC");
captcha.setUrl("https://mysite.com/page/with/funcaptcha");
captcha.setSUrl("https://client-api.arkoselabs.com");
captcha.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.61 Safari/537.36");
captcha.setData("anyKey", "anyValue");
captcha.setProxy("HTTPS", "login:password@IP_address:PORT");
```

### GeeTest
```java
GeeTest captcha = new GeeTest();
captcha.setGt("f2ae6cadcf7886856696502e1d55e00c");
captcha.setApiServer("api-na.geetest.com");
captcha.setChallenge("12345678abc90123d45678ef90123a456b");
captcha.setUrl("https://mysite.com/captcha.html");
captcha.setProxy("HTTPS", "login:password@IP_address:PORT");
```

### hCaptcha
```java
HCaptcha captcha = new HCaptcha();
captcha.setSiteKey("10000000-ffff-ffff-ffff-000000000001");
captcha.setUrl("https://www.site.com/page/");
captcha.setProxy("HTTPS", "login:password@IP_address:PORT");
```

### KeyCaptcha
```java
KeyCaptcha captcha = new KeyCaptcha();
captcha.setUserId(10);
captcha.setSessionId("493e52c37c10c2bcdf4a00cbc9ccd1e8");
captcha.setWebServerSign("9006dc725760858e4c0715b835472f22");
captcha.setWebServerSign2("2ca3abe86d90c6142d5571db98af6714");
captcha.setUrl("https://www.keycaptcha.ru/demo-magnetic/");
captcha.setProxy("HTTPS", "login:password@IP_address:PORT");
```

### Capy
```java
Capy captcha = new Capy();
captcha.setSiteKey("PUZZLE_Abc1dEFghIJKLM2no34P56q7rStu8v");
captcha.setUrl("https://www.mysite.com/captcha/");
captcha.setProxy("HTTPS", "login:password@IP_address:PORT");
```

### Grid
```java
Grid captcha = new Grid();
captcha.setFile("path/to/captcha.jpg");
captcha.setRows(3);
captcha.setCols(3);
captcha.setPreviousId(0);
captcha.setCanSkip(false);
captcha.setLang("en");
captcha.setHintImg(new File("path/to/hint.jpg"));
captcha.setHintText("Select all images with an Orange");
```

### Canvas
```java
Canvas captcha = new Canvas();
captcha.setFile("path/to/captcha.jpg");
captcha.setPreviousId(0);
captcha.setCanSkip(false);
captcha.setLang("en");
captcha.setHintImg(new File("path/to/hint.jpg"));
captcha.setHintText("Draw around apple");
```

### ClickCaptcha
```java
Coordinates captcha = new Coordinates();
captcha.setFile("path/to/captcha.jpg");
captcha.setLang("en");
captcha.setHintImg(new File("path/to/hint.jpg"));
captcha.setHintText("Select all images with an Orange");
```

### Rotate
```java
Rotate captcha = new Rotate();
captcha.setFile("path/to/captcha.jpg");
captcha.setAngle(40);
captcha.setLang("en");
captcha.setHintImg(new File("path/to/hint.jpg"));
captcha.setHintText("Put the images in the correct way up");
```

## Other methods

### send / getResult
```java
String captchaId = solver.send(captcha);

Thread.sleep(20 * 1000);

String code = solver.getResult(captchaId);
```
### balance
```java
double balance = solver.balance();
```
### report
```java
solver.report(captcha.getId(), true); // captcha solved correctly
solver.report(captcha.getId(), false); // captcha solved incorrectly
```

## Error handling
```java
try {
    solver.solve(captcha);
} catch (ValidationException e) {
    // invalid parameters passed
} catch (NetworkException e) {
    // network error occurred
} catch (ApiException e) {
    // api respond with error
} catch (TimeoutException e) {
    // captcha is not solved so far
}
```
[2Captcha]: https://2captcha.com/
