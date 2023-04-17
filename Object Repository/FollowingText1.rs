<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description></description>
   <name>FollowingText1</name>
   <tag></tag>
   <elementGuidId>f1d8e0ea-6617-4b04-afab-b749784efe8f</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>class</name>
      <type>Main</type>
      <value>android.widget.TextView</value>
      <webElementGuid>edfb563d-ef49-4c2d-90a0-73a3a0a5cf20</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${Verify}</value>
      <webElementGuid>e94b625c-9d1e-4c8b-8614-979097772db6</webElementGuid>
   </webElementProperties>
   <locator>(//*[@class = 'android.widget.TextView' and (@text = '${Verify}')]//following-sibling::android.widget.TextView)[1]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
