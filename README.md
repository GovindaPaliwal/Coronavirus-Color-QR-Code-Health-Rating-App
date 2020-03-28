# Color QR Code Health Rating App for Corona Virus
Generate a colored QR code representing the health of person and help to allow / banned entry in workplace, City, local polices and also help to count IN-OUT numbers in lockdown period. 

### Live global stats (provided by [fight-covid19/bagdes](https://github.com/fight-covid19/bagdes)) from this API:**

![Covid-19 Confirmed](https://covid19-badges.herokuapp.com/confirmed/latest?long=true)
![Covid-19 Recovered](https://covid19-badges.herokuapp.com/recovered/latest?long=true)
![Covid-19 Deaths](https://covid19-badges.herokuapp.com/deaths/latest?long=true)

Question with Details |  Safe QR |  Cure QR |  Red Help QR
:-------------------------:|:-------------------------:|:-------------------------:|:-------------------------:
![image](https://github.com/GovindaPaliwal/coronavirus-Color-QR-Code-Health-Rating-App/blob/master/screens/questions.png)  |  ![image](https://github.com/GovindaPaliwal/coronavirus-Color-QR-Code-Health-Rating-App/blob/master/screens/safeqr.png) |  ![image](https://github.com/GovindaPaliwal/coronavirus-Color-QR-Code-Health-Rating-App/blob/master/screens/cureqr.png) |  ![image](https://github.com/GovindaPaliwal/coronavirus-Color-QR-Code-Health-Rating-App/blob/master/screens/redqr.png)


This is very basic module app currently. Now this is only native android app. but if anyone want to follow this idea in own company to allow entry to employee in using colored based QR Code monitoring then use this module with few changes and improvement . 

This idea is inspired by Alipay / Alibaba app. Not same but they include this type of module (In large scale) in there application with gov help for city IN - OUT system.

### How this module work 

Every employee fill out an form with specific field like Emp ID, name etc and fill few question-answer in Yes / No format. With the help of this information user receive a color-based QR-code and status message on their mobile phones which indicating their health status

Users with a red code means instructed to remain quarantined for 14 days and provide regular checkup and entry banned in office workplace.

Users with a yellow QR code means instructed to stay inside for 7 days and entry banned in office workplace.

while users with a green QR code may entry freely but need to stay safe and be careful.

Entry gate watchmen may have asked to view and scan employee QR codes and check employee is ok to enter in building / office or not.

## Note : 
Generate encrypted QR Code with only 1 day validation and 1 QR code for only one person, So other person cannot copy this image or edit this qr code string. Currently working on it.

#Current Version 
In this application currently i generate colour based qr code with specific question related to CORONA VIRUS symptoms with name and id. And user received QR Code after complete this survey form.
And currently working on Scanner module and in future we need to make it server based.

## Used Libraries
* [AwesomeQRCode](https://github.com/SumiMakito/AwesomeQRCode): For Generate QR Code.
* [Awesome Code scanner](https://github.com/GovindaPaliwal/AwesomeCodeScanner): For QR Code Scanner.

### Help are welcome to fast improve and develop this system.
 
### If anyone interesting to develop server side module then please welcome. 

## License

The application is available to the public strictly for educational and research purposes only.
