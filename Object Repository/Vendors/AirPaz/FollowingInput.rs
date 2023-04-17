<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description></description>
   <name>FollowingInput</name>
   <tag></tag>
   <elementGuidId>33f85690-9a6c-48cf-b1dd-68138df3564a</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>class</name>
      <type>Main</type>
      <value>android.view.View</value>
      <webElementGuid>5ad42e29-607f-4557-b5a4-162c580c6024</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${Verify}</value>
      <webElementGuid>0e1d6143-d320-4062-822b-93169cdbee7f</webElementGuid>
   </webElementProperties>
   <locator>//*[@class = 'android.view.View' and (@text = '${Verify}' or . = '${Verify}')]//following-sibling::android.widget.EditText</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
