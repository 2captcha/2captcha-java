# JAVA Module for 2Captcha API
The easiest way to quickly integrate [2Captcha] into your code to automate solving of any types of captcha.

- [Installation](#installation)
- [Configuration](#configuration)
- [Solve captcha](#solve-captcha)
  - [Normal Captcha](#normal-captcha)
  - [Text](#text-captcha)
  - [ReCaptcha v2](#recaptcha-v2)
  - [ReCaptcha v3](#recaptcha-v3)
  - [FunCaptcha](#funcaptcha)
  - [GeeTest](#geetest)
  - [GeeTestV4](#geetestv4)
  - [hCaptcha](#hcaptcha)
  - [KeyCaptcha](#keycaptcha)
  - [Capy](#capy)
  - [Grid (ReCaptcha V2 Old Method)](#grid)
  - [Canvas](#canvas)
  - [ClickCaptcha](#clickcaptcha)
  - [Rotate](#rotate)
  - [Audio](#audio)
  - [Yandex](#yandex)
  - [Lemin](#lemin)
- [Other methods](#other-methods)
  - [send / getResult](#send--getresult)
  - [balance](#balance)
  - [report](#report)
- [Error handling](#error-handling)


## Installation
2captcha-java artifact is available in [Maven Central]

## Configuration
`TwoCaptcha` instance can be created like this:
```java
TwoCaptcha solver = new TwoCaptcha('YOUR_API_KEY');
```
Also there are few options that can be configured:
```java
solver.setHost("2captcha.com");
solver.setSoftId(123);
solver.setCallback("https://your.site/result-receiver");
solver.setDefaultTimeout(120);
solver.setRecaptchaTimeout(600);
solver.setPollingInterval(10);
```

### TwoCaptcha instance options

|Option|Default value|Description|
|---|---|---|
|softId|-|your software ID obtained after publishing in [2captcha sofware catalog]|
|callback|-|URL of your web-sever that receives the captcha recognition result. The URl should be first registered in [pingback settings] of your account|
|defaultTimeout|120|Polling timeout in seconds for all captcha types except ReCaptcha. Defines how long the module tries to get the answer from `res.php` API endpoint|
|recaptchaTimeout|600|Polling timeout for ReCaptcha in seconds. Defines how long the module tries to get the answer from `res.php` API endpoint|
|pollingInterval|10|Interval in seconds between requests to `res.php` API endpoint, setting values less than 5 seconds is not recommended|

>  **IMPORTANT:** once *callback URL* is defined for `TwoCaptcha` instance with `setCallback`, all methods return only the captcha ID and DO NOT poll the API to get the result. The result will be sent to the callback URL.
To get the answer manually use [getResult method](#send--getresult)

## Solve captcha
When you submit any image-based captcha use can provide additional options to help 2captcha workers to solve it properly.

### Captcha options
|Option|Default Value|Description|
|---|---|---|
|numeric|0|Defines if captcha contains numeric or other symbols [see more info in the API docs][post options]|
|minLength|0|minimal answer lenght|
|maxLength|0|maximum answer length|
|phrase|0|defines if the answer contains multiple words or not|
|caseSensitive|0|defines if the answer is case sensitive|
|calc|0|defines captcha requires calculation|
|lang|-|defines the captcha language, see the [list of supported languages] |
|hintImg|-|an image with hint shown to workers with the captcha|
|hintText|-|hint or task text shown to workers with the captcha|

Below you can find basic examples for every captcha type. Check out [examples directory] to find more examples with all available options.

### Basic example
Example below shows a basic solver call example with error handling.

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

### Normal Captcha
To bypass a normal captcha (distorted text on image) use the following method. This method also can be used to recognize any text on the image.

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
This method can be used to bypass a captcha that requires to answer a question provided in clear text.

```java
Text captcha = new Text();
captcha.setText("If tomorrow is Saturday, what day is today?");
captcha.setLang("en");
```

### ReCaptcha v2
Use this method to solve ReCaptcha V2 and obtain a token to bypass the protection.

```java
ReCaptcha captcha = new ReCaptcha();
captcha.setSiteKey("6Le-wvkSVVABCPBMRTvw0Q4Muexq1bi0DJwx_mJ-");
captcha.setUrl("https://mysite.com/page/with/recaptcha");
captcha.setInvisible(true);
captcha.setAction("verify");
captcha.setProxy("HTTPS", "login:password@IP_address:PORT");
```
### ReCaptcha v3
This method provides ReCaptcha V3 solver and returns a token.

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
FunCaptcha (Arkoselabs) solving method. Returns a token.

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
Method to solve GeeTest puzzle captcha. Returns a set of tokens as JSON.

```java
GeeTest captcha = new GeeTest();
captcha.setGt("f2ae6cadcf7886856696502e1d55e00c");
captcha.setApiServer("api-na.geetest.com");
captcha.setChallenge("12345678abc90123d45678ef90123a456b");
captcha.setUrl("https://mysite.com/captcha.html");
captcha.setProxy("HTTPS", "login:password@IP_address:PORT");
```

### GeeTestV4
Method to solve GeeTestV4 puzzle captcha. Returns a set of tokens as JSON.

```java
GeeTestV4 captcha = new GeeTestV4();
captcha.setCaptchaId("72bf15796d0b69c43867452fea615052");
captcha.setApiServer("api-na.geetest.com");
captcha.setChallenge("12345678abc90123d45678ef90123a456b");
captcha.setUrl("https://mysite.com/captcha.html");
captcha.setProxy("HTTPS", "login:password@IP_address:PORT");
```

### hCaptcha
Method to solve GeeTest puzzle captcha. Returns a set of tokens as JSON.

```java
HCaptcha captcha = new HCaptcha();
captcha.setSiteKey("10000000-ffff-ffff-ffff-000000000001");
captcha.setUrl("https://www.site.com/page/");
captcha.setProxy("HTTPS", "login:password@IP_address:PORT");
```

### KeyCaptcha
Token-based method to solve KeyCaptcha.

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
Token-based method to bypass Capy puzzle captcha.

```java
Capy captcha = new Capy();
captcha.setSiteKey("PUZZLE_Abc1dEFghIJKLM2no34P56q7rStu8v");
captcha.setUrl("https://www.mysite.com/captcha/");
captcha.setProxy("HTTPS", "login:password@IP_address:PORT");
```

### Grid
Grid method is originally called Old ReCaptcha V2 method. The method can be used to bypass any type of captcha where you can apply a grid on image and need to click specific grid boxes. Returns numbers of boxes.

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
Canvas method can be used when you need to draw a line around an object on image. Returns a set of points' coordinates to draw a polygon.

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
ClickCaptcha method returns coordinates of points on captcha image. Can be used if you need to click on particular points on the image.

```java
Coordinates captcha = new Coordinates();
captcha.setFile("path/to/captcha.jpg");
captcha.setLang("en");
captcha.setHintImg(new File("path/to/hint.jpg"));
captcha.setHintText("Select all images with an Orange");
```

### Rotate
This method can be used to solve a captcha that asks to rotate an object. Mostly used to bypass FunCaptcha. Returns the rotation angle.

```java
Rotate captcha = new Rotate();
captcha.setFile("path/to/captcha.jpg");
captcha.setAngle(40);
captcha.setLang("en");
captcha.setHintImg(new File("path/to/hint.jpg"));
captcha.setHintText("Put the images in the correct way up");
```

### Audio
This method can be used to solve a audio captcha

```java
TwoCaptcha solver = new TwoCaptcha("YOUR_API_KEY");
byte[] bytes = Files.readAllBytes(Paths.get("src/main/resources/audio-en.mp3"));
String base64EncodedImage = Base64.getEncoder().encodeToString(bytes);
Audio captcha = new Audio();
captcha.setBase64(base64EncodedImage);
```

### Yandex
Use this method to solve Yandex and obtain a token to bypass the protection.

```java
TwoCaptcha solver = new TwoCaptcha("YOUR_API_KEY");
Yandex captcha = new Yandex();
captcha.setSiteKey("Y5Lh0tiycconMJGsFd3EbbuNKSp1yaZESUOIHfeV");
captcha.setUrl("https://rutube.ru");
```

### Lemin
Use this method to solve Lemin and obtain a token to bypass the protection.

```java
TwoCaptcha solver = new TwoCaptcha("YOUR_API_KEY");
Lemin captcha = new Lemin();      
captcha.setСaptchaId("CROPPED_d3d4d56_73ca4008925b4f83a8bed59c2dd0df6d");
captcha.setUrl("http://sat2.aksigorta.com.tr");
captcha.setApiServer("api.leminnow.com");
```

## Other methods

### send / getResult
These methods can be used for manual captcha submission and answer polling.

```java
String captchaId = solver.send(captcha);

Thread.sleep(20 * 1000);

String code = solver.getResult(captchaId);
```
### balance
Use this method to get your account's balance

```java
double balance = solver.balance();
```
### report
Use this method to report good or bad captcha answer.

```java
solver.report(captcha.getId(), true); // captcha solved correctly
solver.report(captcha.getId(), false); // captcha solved incorrectly
```

## Error handling
If case of an error captcha solver throws an exception. It's important to properly handle these cases. We recommend to use `try catch` to handle exceptions.

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
[Maven Central]: https://search.maven.org/artifact/com.github.2captcha/2captcha-java
[examples directory]: /src/main/java/examples
[2Captcha]: https://2captcha.com/
[2captcha sofware catalog]: https://2captcha.com/software
[pingback settings]: https://2captcha.com/setting/pingback
[post options]: https://2captcha.com/2captcha-api#normal_post
[list of supported languages]: https://2captcha.com/2captcha-api#language
