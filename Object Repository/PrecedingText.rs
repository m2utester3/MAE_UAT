<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description></description>
   <name>PrecedingText</name>
   <tag></tag>
   <elementGuidId>1b34abf8-abcf-41ed-bd9b-98fb1f837093</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>class</name>
      <type>Main</type>
      <value>android.widget.TextView</value>
      <webElementGuid>350474b9-e1fc-4264-b4bd-e0fe94a5ed1c</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${Verify}</value>
      <webElementGuid>0b1cefc5-3d0d-4764-96a2-4422b3bfe11b</webElementGuid>
   </webElementProperties>
   <locator>//*[@class = 'android.widget.TextView' and (@text = '${Verify}' or . = '${Verify}')]//preceding-sibling::android.widget.TextView</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
