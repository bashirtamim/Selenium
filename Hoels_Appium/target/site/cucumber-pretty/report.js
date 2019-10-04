$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("hotel_login.feature");
formatter.feature({
  "line": 2,
  "name": "Verify hotel conditions",
  "description": "",
  "id": "verify-hotel-conditions",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@mobile-regression"
    },
    {
      "line": 1,
      "name": "@hotel"
    }
  ]
});
formatter.before({
  "duration": 31149265058,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I click on ok button on splash screen",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I click on menu button on splash screen",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "ok",
      "offset": 11
    }
  ],
  "location": "MobileTestScenarios.clickOnSplashScreenButton(String)"
});
formatter.result({
  "duration": 6441107607,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "menu",
      "offset": 11
    }
  ],
  "location": "MobileTestScenarios.clickOnSplashScreenButton(String)"
});
formatter.result({
  "duration": 344983183,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Verify invalid login for hotel app",
  "description": "",
  "id": "verify-hotel-conditions;verify-invalid-login-for-hotel-app",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 8,
      "name": "@mobile-regression"
    },
    {
      "line": 8,
      "name": "@hotel-1"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "I click on sign in button on splash screen",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "I enter mohammad@technosoftsolutions.io into username text field on sign in screen",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "I enter test1234 into password text field on sign in screen",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I click on sign in button on sign in screen",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I verify invalid sign in error message",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "sign in",
      "offset": 11
    }
  ],
  "location": "MobileTestScenarios.clickOnSplashScreenButton(String)"
});
formatter.result({
  "duration": 1523913181,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "mohammad@technosoftsolutions.io",
      "offset": 8
    },
    {
      "val": "username",
      "offset": 45
    }
  ],
  "location": "MobileTestScenarios.enterUsernameAndPassword(String,String)"
});
formatter.result({
  "duration": 5679791080,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "test1234",
      "offset": 8
    },
    {
      "val": "password",
      "offset": 22
    }
  ],
  "location": "MobileTestScenarios.enterUsernameAndPassword(String,String)"
});
formatter.result({
  "duration": 5188338615,
  "status": "passed"
});
formatter.match({
  "location": "MobileTestScenarios.signInButton()"
});
formatter.result({
  "duration": 1290049397,
  "status": "passed"
});
formatter.match({
  "location": "MobileTestScenarios.verifyInvalidSignInErrorMessage()"
});
formatter.result({
  "duration": 1437496953,
  "status": "passed"
});
formatter.after({
  "duration": 5512632416,
  "status": "passed"
});
});