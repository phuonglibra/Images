@tag
Feature: Images

  Scenario: Capture in English
   Given the page "https://cucumber.io/" is visited
   When capture image of "css=img.img-responsive" element and save as "Step3.png"
   Then assert that image of "css=img.img-responsive" element and expected "Step3.png" image is similar