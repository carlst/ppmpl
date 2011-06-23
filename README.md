# JavaScript PayPal MPL #

JavaScript PayPal MPL is a JavaScript-Java bridge to the PayPal Mobile Payment Library (MPL)
for Android.

It allows JavaScript native apps to use the PayPal MPL for Android (just like Java native apps)
without adding any payment code (to send credentials securely) to a back-end web server.


## Installation ##

To install:  
- Copy src/com/ppmpl/mpl.java and src/com/ppmpl/ResultDelegate.java to your project src/com/ directory
- Change the package names at the top of the files just copied to the package name of your project  
- Download and install the PayPal Mobile Payment Library (MPL) - Android Library
from https://www.x.com/community/ppx/sdks  
- Copy PayPal_MPL.jar from the PayPal MPL into your project as libs/PayPal_MPL.jar  
- If you are creating a new project, src/com/ppmpl/ppmpl.java may be copied into your
project as src/com/&lt;project&gt;/&lt;project&gt;.java  and edited. 
Be sure to change the package name to the package name of your project  
- If you are modifying an existing project, use src/com/ppmpl/ppmpl.java as a template
for adding the JavaScript-Java interface code to your project  
- Check that your project has sufficient permissions, including at least the 'uses-permission' lines from AndroidManifest.xml  
- Copy the 'com.paypal.android.MEP.PayPalActivity' activity section from AndroidManifest.xml into your AndroidManifest.xml file


## Synopsis ##

Use the following JavaScript library calls in JavaScript code:

* Initialization  
mpl.prepare(0);  // goods(0), services(1), personal(2)

Check initialization status (recheck until status == "1")  
status = mpl.getStatus();

* Set payment information  
obj = {};  
obj.paymentAmount = '29.99';  
obj.paymentCurrency = 'USD';  
obj.recipient = 'foo@example.com';  
obj.itemDesc = 'some description';  
obj.merchantName = 'some merchant';  
obj.customID = 'some identifier';  
obj.ipnUrl = 'some URL';  
obj.tax = '';  
obj.shipping = '';  
str = JSON.stringify(obj);  
mpl.setPaymentInfo(str);  

* Make payment  
mpl.pay(0);

* Get payment results
str = mpl.getPaymentResults();  
obj = JSON.parse(str);

See obj['resultTitle'], obj['resultInfo'], obj['resultExtra']  

## Example ##

See assets/www/index.html for example code.


## Testing ##

The library can be tested against a standalone server (PayPal.ENV_NONE), 
a PayPal sandbox server (PayPal.ENV_SANDBOX), or on a live PayPal server (PayPal.ENV_LIVE).

The server type is configured during library initialization (see src/com/ppmpl/ppmpl.java).

The standalone system is self-contained in the PayPal MPL. To setup a sandbox or a live account,
see https://developer.paypal.com  


## Questions or Comments ##

Please post questions or comments on <a href="http://github.com/carlst/ppmpl/issues">Github</a>
