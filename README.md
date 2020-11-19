# CyclePricingEngine

#Below file specifies the prices for each component 
CyclePricingEngine/src/main/java/com/pricingengine/resources/component_prices.properties


#App supports both JSON String input or JSON File input as mentioned below 

1) Sample JSON input String
[{"frame":{"color":"red","materialtype":"steel"},"handleBar":{"color":"black","frontBreak":"disc","rearBreak":"disc"},"wheels":{"rimtype":"alloy","tyretype":"tubeless"},"chainAssembly":{"noOfGears":"4"},"purchasingDate":"17\/11\/2020"}]

2) Sample input JSON file location
CyclePricingEngine/src/main/java/com/pricingengine/resources/cycleorder.json


#Main classes
#Application Flow starts here
CyclePricingEngine/src/main/java/com/pricingengine/main/PricingEngineMain.java
CyclePricingEngine/src/main/java/com/pricingengine/main/PricingEngineHelper.java

