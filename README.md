# UITestsBelong

***Please branch out from DEMO and start assignment***
Write feature file , step definitions and if possible pages for any of the below two requirements 

Site URL: http://automationpractice.com/

1.	While registering, if the email address is incorrect. User should see an error message
2.	Check whether Megamenu works (Dresses -> Summer dresses)
3.	On the Summer dresses page, select a dress(Quick view) and change the color (Blue) and then add the item to cart, Validate	whether same product name, color and quantity are displayed in Cart Summary page.

Complete your assignment in your branch 

**Steven Yip**
- Requirements 1 and 3 implemented. In implementing #3, the 2nd requirement was also addressed anyway.
- Apologies in advances, I developed this on a Windows 10 platform so some of the imports and inclusions may not work on another platform/OS. I developed the tests primarily with ChromeDriver 77.0.3865.40, x86 version, from https://chromedriver.chromium.org/downloads, and later verified they work on geckodriver v0.29.
- At first I tried to use JDK 11.0.5, but upon running the test I enountered the following showstopper:
```
WARNING: An illegal reflective access operation has occurred  
WARNING: Illegal reflective access by cucumber.deps.com.thoughtworks.xstream.core.util.Fields (file:/C:/Users/Telstra%20User/.m2/repository/info/cukes/cucumber-jvm-deps/1.0.5/cucumber-jvm-deps-1.0.5.jar) to field java.util.TreeMap.comparator  
WARNING: Please consider reporting this to the maintainers of cucumber.deps.com.thoughtworks.xstream.core.util.Fields  
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations  
WARNING: All illegal access operations will be denied in a future release  
```
- The quick fix was to use JDK 1.8 instead, as per https://backstage.forgerock.com/knowledge/kb/article/a15048811
