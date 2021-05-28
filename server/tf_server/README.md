# How to use Tensorflow Model Serving with Docker

Source: [TF Serving with Docker](https://www.tensorflow.org/tfx/serving/docker)

## Fast Tour
```bash
# Download the TensorFlow Serving Docker image and repo
docker pull tensorflow/serving

git clone https://github.com/tensorflow/serving
# Location of demo models
TESTDATA="$(pwd)/serving/tensorflow_serving/servables/tensorflow/testdata"

# Start TensorFlow Serving container and open the REST API port
docker run -t --rm -p 8501:8501 \
    -v "$TESTDATA/saved_model_half_plus_two_cpu:/models/half_plus_two" \
    -e MODEL_NAME=half_plus_two \
    tensorflow/serving &

# Query the model using the predict API
curl -d '{"instances": [1.0, 2.0, 5.0]}' \
    -X POST http://localhost:8501/v1/models/half_plus_two:predict

# Returns => { "predictions": [2.5, 3.0, 4.5] }
```

## Download TF Serving Docker Image
```bash
docker pull tensorflow/serving
```

# Run with Your Model
1. Place your model on ```model`` folder.
1. Let's say your model is ```model/resnet50_bgmodify/1/...```</br>
To run the container:
```bash
docker run -t --rm -p 8501:8501  --name tfserving \                 
    -v "$(pwd)/model/resnet50_bgmodify:/models/resnet50_bgmodify" \
    -e MODEL_NAME=resnet50_bgmodify \
    tensorflow/serving &
```
    

