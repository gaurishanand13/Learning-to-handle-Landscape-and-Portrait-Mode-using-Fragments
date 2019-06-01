# Fragment_part3
In this Fragment we will not only use fragments for landscape mode but also for portrait mode. For this we will create 2 mainActivity xml files - one for when the phone is in portrait mode and the other for the landscape mode
. If only one MainActivity xml file is present -> then android studio uses it for both portrait and landcape mode. But if 2 MainActivity xml files are present then the already present xml file is assumed to be for portrait mode.
Thus we will create the file for landscape mode(i.e the second MainActivity xml file)
-> right click on res(on left pallete window) -> New -> directory -> name it as "layout-land";
Now copy the already present xml file i.e mainActivty.xml file and paste in the layout-land folder which is in the resources. You can can do by clicking "reveal in folder" on res.
## Now you have created two seperate xml files for both landscape and portrait. Just Make sure you change the names of their id's of their layout if you want to use them seperately as i have used it here. As at a time only one will be active i.e either landscape one or portrait one and the other will be null
Therefor when i changed the id's. It looked like this.
</br>
![Screen Shot 2019-06-01 at 5 26 40 AM](https://user-images.githubusercontent.com/43893611/58740757-e01f7c80-842f-11e9-8196-a606de544a3e.png)
![Screen Shot 2019-06-01 at 5 26 52 AM](https://user-images.githubusercontent.com/43893611/58740759-e281d680-842f-11e9-988b-9f58f0993065.png)
</br>
My App will look like this -> 
</br>
![WhatsApp Image 2019-06-01 at 5 43 25 AM (1)](https://user-images.githubusercontent.com/43893611/58740824-87041880-8430-11e9-929e-86bdedf48ae1.jpeg)
![WhatsApp Image 2019-06-01 at 5 43 25 AM (2)](https://user-images.githubusercontent.com/43893611/58740825-88354580-8430-11e9-92b1-f9639cff1f67.jpeg)
![WhatsApp Image 2019-06-01 at 5 43 25 AM](https://user-images.githubusercontent.com/43893611/58740827-8a979f80-8430-11e9-9382-a1fe1c92363c.jpeg)
