# SMARTWiFi
SMARTWifi is Android applcation that manipulates the WifiMananger and LocationManager services to create a better user-wifi-experience.

## Features
* Threshold
* Priority
* Geo-Fencing
* Access Point
* Data-Logging

### Threshold
Set a connect / disconnect threshold which will automatically make your Wifi connect/reassociate/disconnect when the signal(RSSI)Strength drops below or goes above the thresholds.  

SMARTWifi will try to reassociate to an alternative Access Point(Same SSID) when the disconnect threshold is met, if there are none if then searchs for any Access Points that are available as well as above the Threshold, and lastly if there are none it will disconnect.

#### To be implemented
STANDOFF if a user selects something below threshold / threshold is disabled / threshold is put in a standoff mode

#### Benefits
Although reassociating Access Points can be costly, having poor signal strength (especially while mobile) causes dropped packets that need to be resent which will add work to the access point, limited your bandwidth, and decrease your user-experience.

### Priority
Set a priority list of networks in the order in which you want to connect.  This will allow you to specify which networks should be connected to first or switch to when they become available.

Currently Android doesn't allow this and whichever network first comes in range will be the one that you will connect to.  So if you connect to a poor quality network while a better comes in range after connection android will not make the switch for you.  SMARTWifi will though.

#### To be implemented
STANDOFF if a user selects something non-priority / priority is disabled / priority is put in a standoff mode

### Geo-Fencing

Geo-Fencing will allow the user to add locations that will trigger their Wifi to turn on and off when they enter / exit the fence.  The fence is created as a circle with the center being at the lat/long and the radius as specified by the user.

The user will add Geo-locations(lat/long) and radius within the app, which will be stored into an SQlite database. 

#### To be implemented
STANDOFF if a user manually turns on or off their wifi Geo-fencing will be put in a standoff mode.

### Access Point

Access Point connection to networks will allow the user to add specific access points to be connected to.  This will base the connection off of a access points basic service set identifier (BSSID) 

The user will add Access Points within the app, which will be stored into an SQlite database. 

#### To be implemented
STANDOFF if the user selects something to connect to outside of the application, Access Point is put in a standoff mode

### Data-Logging
Data logging will log all the DateTime/Wifi/GPS Data, it will actively get the GPS data and Wifi Connection info (the wifi you are currently associated with) as well as period scans of all the networks (might implement this in a different but similar file)

### Maching Learning? 
Using the data from the data logging plus user interaction, the app could easier have all of the parameters set by basic use of the user.

STANDOFF data will be collected in a seperate area besides data logging to monitor user actions.

## Authors
* **Johnny Winters**
Email: winters.john at gmail.com jtwyp6 at mail.missouri.edu

This is a just a project I'm working on as a proof of concept.  There might be missing pieces / future work that can be added later if needed

### Future work
* Logging and The Addition of a standoff feature
