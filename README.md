<h3>Image Upload Using Spring boot and Thymeleaf</h3>
<div>This demo show you how to upload an image to the file system and store the path and image details in the database</div>
<p>
  Change the path to store the image to your system path. Changes will be done in line 24, 25 of the FileDataService class, as shown below:<br>
  <code>
    String file_path = "/Users/josiah/Desktop/imagefiles/" + multipartFile.getOriginalFilename();
    String filedir = "/Users/josiah/Desktop/imagefiles/";
  </code>
  dont forget to close the inputStream object at the end.
</p>
<p>
  Also, For windows users, using wampserver or mysql workbench, you will be required to make changes to the application.properties 
  file to reflect your MySQl port.
</p>
<p>
  Thanks and enjoy!
</p>
PS: do a pull request for any modification done or a better approach.
