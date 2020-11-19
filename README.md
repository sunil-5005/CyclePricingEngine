# CyclePricingEngine

#Below file specifies the prices for each component 
CyclePricingEngine/src/main/resources/resources/component_prices.properties


#Main classes
#Application Flow starts here
CyclePricingEngine/src/main/java/com/pricingengine/main/PricingEngineMain.java
CyclePricingEngine/src/main/java/com/pricingengine/main/PricingEngineHelper.java

#Inputs Description
- App supports both JSON String input or JSON File input as mentioned below 
- Input has to be JSONArray which will have JSONObject values mentioned inside brackets are the possible values for the field
1) Sample JSON input String
Ex. [{"frame":{"color":"red","materialtype":"steel"},"handleBar":{"color":"black","frontBreak":"disc","rearBreak":"disc"},"wheels":{"rimtype":"alloy","tyretype":"tubeless"},"chainAssembly":{"noOfGears":"4"},"purchasingDate":"17\/11\/2020"}]

2) Sample input JSON file location
- Here we need to specify Fully Qualified Name of the file

Ex. D:\workspace-spring-tool-suite-4-4.7.1.RELEASE\CyclePricingEngine\src\main\resources\cycleorder.json


Example with possible values for the fields

[
	{
		"frame": {
			"color": "red",
			"materialtype": "steel"(steel/aluminium)
		},
		"handleBar": {
			"color": "black",
			"frontBreak": "disc",(disc/drum)
			"rearBreak": "disc"(disc/drum)
		},
		"wheels": {
			"rimtype": "alloy",(alloy/spoke)
			"tyretype": "tubeless"(tubeless/tyrewithtube)
		},
		"chainAssembly": {
			"noOfGears": "4"
		},
		"purchasingDate": "17/11/2020"(format: d/MM/yyyy)
	}]
	

