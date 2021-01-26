# SWE 522 Sentiment Analysis Project

## Group Members

* Ezgi Şendil
* Umut Yılmaz
* Uğur Gürkan Tosun

## Project Motivation

In the scope of crowd analysis project, we decided to perform a study about sentiment analysis <br>
with using NLP approach and currently available libraries and technologies. In this direction, our project covers <br>
sentiment analysis of user reviews of several application categories. These user reviews are collected from <br>
App Store. This study covers only App Store reviews of application are listed in below;

Categories: 

* Photo & Video
* Social Networking
* Entertainment
* Productivity
* Food & Shopping

In our work, each application category consisting of three application as listed in below;

#### 1 - Photo & Video

* Pinterest
* Youtube
* TikTok

#### 2 - Social Networking

* Whatsapp
* Facebook
* Messenger

#### 3 - Entertainment

* Hulu
* Roblox
* Spotify

#### 4 - Productivity

* Outlook
* Google Docs
* Google Drive

#### 5 - Food & Shopping

* Uber Eats
* Wish
* Google Maps

## Data Collection

In the data collection part of project, we do not use a ready dataset. We prepared the dataset with <br>
collecting data from App Store. For this purpose, an open source API (https://data.42matters.com/api/v2.0/ios/apps/reviews) was used to fetch application reviews with respecting date. <br>
With fetching data from API, we wrote these application reviews to Postgresql database. <br>

The java project which was developed to handle data preparation is available with link in below; <br>
Also project would be shared with project files.

```
https://github.com/ugurtosun/SentimentAnalysisDataCollection
```

In the database columns are;

* app_id
* category_id
* author_id
* title
* rating
* review
* date

We used actually review data for sentiment analysis. Each app has 100 reviews for each month <br>
between 2019-01-01 and 2021-01-01. So, totally 2400 reviews were collected for each application. <br>
Hence, there are 7200 reviews for each category. Total database consisting of almost 36000 review entries. <br>

The .csv form of dataset will be shared with project documentation. 

## Data Processing And Sentiment Analysis

In the data processing and sentiment analysis part of project, we aimed to explore a relationship <br>
between pre-pandemic and pandemic periods. In method, we collected user reviews from each month of 2019 and 2020. <br>
We extract some graphics which will be detailed in next parts of document. 

Firstly, we save our work in Jupyter Notebook file because becoming easy to follow steps.  

```

```




