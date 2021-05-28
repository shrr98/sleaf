FROM ubuntu:18.04
RUN apt-get update && \
    apt-get install --no-install-recommends -y \
    python3 python3-pip python3-dev build-essential
RUN apt-get install ffmpeg libsm6 libxext6  -y
RUN python3 -m pip install --upgrade pip setuptools wheel

COPY requirements.txt /app/
WORKDIR /app
RUN pip3 install -r requirements.txt

COPY model/labels.txt /app/model/labels.txt
COPY resources /app/resources
COPY sleaf.py /app
COPY classifier.py /app
COPY __init__.py /app

EXPOSE 5000