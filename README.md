# sleaf
S-Leaf: Leaf recognition for plant information retrieval

## Training the Model
To train the model, you can use this [training notebook](ML/training/Training.ipynb).</br>
If you want to use the background images we use on this experiment, you can download it on [this link](https://drive.google.com/file/d/1K8Hvf6wJtrlG9iczYZsow_s7UO5oZ1D4/view?usp=sharing) and upload it to your Google Drive.

## Deploying the Model
[!] After training, make sure that you already save your model in your drive.</br>
If you want to use our pre-trained model, you can download it on our drive:
1. [Model](https://drive.google.com/file/d/1uAap0Hb_ogwAXMGeVJVUjHO-QvQpXs4e/view?usp=sharing).
1. [Label](https://drive.google.com/file/d/1-K-tpanQIdtBaZUbhyAg7V1b3XgFVGnJ/view?usp=sharing)

To deploy the model on Google Compute Engine:
1. Clone this repository on your VM instance
1. Go to ```server/main_server```.
1. Download your model that's already saved in Google Drive by following [this tutorial](https://medium.com/@acpanjan/download-google-drive-files-using-wget-3c2c025a8b99). </br>
    Save it in ```server/main_server/model```.
1. Build your docker image. Run this command:
    ```bash
    sudo docker build -t sleaf:latest .
    ```
1. Run your docker image.
    ```bash
    sudo docker run --detach -v "$(pwd)/model/[your model dir]:/app/model/custom_bgmodify" -p 80:8080 sleaf:latest
    ```
1. Test your API. Run this command on your CLI:
    ```bash
    curl http://127.0.0.1/
    ```
    You should get this response:
    ```
    Welcome to S-LEAF!
    ```
    You can check the detail of the API on [this documentation](server/main_server/README.md). </br>
    To test the model deployment, you need to use the Application.

## Building the Apps
