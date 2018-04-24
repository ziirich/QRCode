# QRCode
This is a project for QRCode Generation and QRCode Recognition
This project is based on Google Zxing QRCode Generation and Recognition Toolkit and sarxos(https://github.com/sarxos/webcam-capture), of course I have made a little modification on it.
## Usage
You can use the qrcode display function as following demo code:

For display module
```java
    Screen scr = new Screen();
    scr.display("Hello World!");
```
Tips:
You should handle the `WriterException` in scr.display calling.

For screen module
```java
    Camera c = new Camera();
    String whatyougot = c.scan();
```

## Contact me
```javascript
  var callme = {
    nickName:"Adam Ziirich",
    email:"adam@barsf.org"
  }
```
