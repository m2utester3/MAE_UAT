<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description></description>
   <name>FollowingInput</name>
   <tag></tag>
   <elementGuidId>42e60fdc-52da-47ae-b26c-7f5bcd4b72b6</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>class</name>
      <type>Main</type>
      <value>android.widget.TextView</value>
      <webElementGuid>c5037de2-5f14-4b00-9766-06ef1aa1533b</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${Verify}</value>
      <webElementGuid>ff7e0958-70fd-45c7-96fa-501a8d5c7f1a</webElementGuid>
   </webElementProperties>
   <locator>//*[@class = 'android.widget.TextView' and (@text = '${Verify}' or . = '${Verify}')]//following-sibling::android.view.ViewGroup/android.widget.EditText</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
