# EmergenSpeech

**Shashank Mahesh**

**Pranav Atreya**
# 
An Android app that uses speech-recognition to provide medical help for someone who has just had a medical emergency before Medical help arrives.

## What it does
This app uses voice recognition and text analysis to provide for a quick service to people when they see someone who has just had a medical emergency. The person can describe the symptoms the person who has had the medical emergency is facing, and the app will be able to determine what medical condition the user is describing and recommend steps taken to help the person before professional medical aid arrives.

## How I Built it
We built the app on the Android platform and utilized Google's speech to text APIs for processing the words said by the user. This text information was relayed via network to a python backend, in which a neural network capable of determining the medical condition based solely on described symptoms that was trained using TensorFlow processed this text information. Ultimately the app referenced a database of steps needed to be taken during a certain medical condition, and informed the user of these steps.

## Inspiration
The inspiration for this project came as we were thinking about some naturally arising issues with the current healthcare and emergency aid system. Although some people are trained on how to perform first aid measures, we realized the majority of the population is not, and thus in emergency situations people will not know what to do until medical aid arrives.

## Challenges we ran into
One of the greatest challenges was merging the python backend and android app. Our initial plan was running an Android compatible version of the neural network on the app itself, but we faced difficulties in implementation. Ultimately we decided upon a network communication as the medium for information traversal. This choice of system would be reliable and keep the app lightweight.
