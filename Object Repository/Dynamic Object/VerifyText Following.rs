<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description></description>
   <name>VerifyText Following</name>
   <tag></tag>
   <elementGuidId>f522ef34-8ef6-4315-83e9-2c94966dd148</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <locator>(//*[@class = 'android.widget.TextView' and (@text = '${text}' or . = '${text}')]//following-sibling::android.widget.TextView)[${index}]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
