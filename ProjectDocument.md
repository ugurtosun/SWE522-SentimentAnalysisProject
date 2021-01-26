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
.ipynb and .html forms of our final notebook will be shared with project documentation. 
<br>
<br>
Importing necessary libraries and packages
```
import numpy as np              
import matplotlib.pyplot as plt 
import pandas as pd

import string
from collections import Counter
import matplotlib.pyplot as plt
import nltk

from nltk.corpus import stopwords
from nltk.sentiment.vader import SentimentIntensityAnalyzer
from nltk.sentiment import SentimentAnalyzer
from nltk.stem import WordNetLemmatizer
from nltk.tokenize import word_tokenize
nltk.download('punkt')
nltk.download('stopwords')
nltk.download('wordnet')
nltk.download('vader_lexicon')
```

Reading dataset which is exported in csv format from postgresql database.<br>
Basically, four data labels category_id, app_id, content and date information are needed 
```
raw_dataset = pd.read_csv('data/reviews.csv')
reviews_dataset = raw_dataset[["category_id", "app_id", "content", "date"]]
```

The main calculateAverage(dataset) function is designed for calculation of average sentiment compound score for given dataset.
In this part, we use SentimentAnalyzer() function of NLTK. <br>

The process is consisting of operations which are listed below;

* Lowercasing the words
* Tokenizing words
* Creating a final sentence without stop words
* Getting polarity scores of SentimentIntensityAnalyser for each sentence.

At that point, we use compound score for defining user sentiment score. 

```
def calculateAverage(dataset):
    reviews_dataset_date2 = dataset
    count_row = reviews_dataset_date2.shape[0]
    #reviews_dataset.head(100)
    #print(count_row)
    reviews_dataset_date2.head(100)
    
    review_list = reviews_dataset_date2["content"]
    cleaned_review_list = []

    for review in review_list:
        #review_lower_case = review.lower()
        review_cleaned_text = str(review).translate(str.maketrans('', '', string.punctuation))
        tokenized_words = word_tokenize(review_cleaned_text, "english")
        final_words = []
        for word in tokenized_words:
            if word not in stopwords.words('english'):
                final_words.append(word)

        final_sentence = ""    

        for word in final_words:
          final_sentence = final_sentence + word + " "

        cleaned_review_list.append(final_sentence)

    cleaned_review_dataframe = pd.DataFrame(cleaned_review_list, columns=['content'])
    #print(cleaned_review_dataframe.shape[0])
    #cleaned_review_dataframe.head(10)

    sia = SentimentIntensityAnalyzer()

    result_list = []

    for final_review in cleaned_review_list:
        result = sia.polarity_scores(final_review)
        result_list.append(result)

    len(result_list)  


    total = 0
    counter = 0
    for result in result_list:
         total += result['compound']
         counter = counter + 1 

    if(counter == 0):
        print("Warning....")
        return 0
    
    average = total / counter
    return average
```

There are more coding part to handle each application and category. We do not add all <br>
code pieces in a documentation, all code parts and results are shown in shared Jupyter notebook or html output of notebook.

## Results And Discussion

### Results for individual apps

![alt text](http://github.com/ugurtosun/SentimentAnalysisDataCollection/blob/master/assets/pinterest.jpg?raw=true)

![alt text](http://github.com/ugurtosun/SentimentAnalysisDataCollection/blob/master/assets/youtube.jpg?raw=true)

![alt text](http://github.com/ugurtosun/SentimentAnalysisDataCollection/blob/master/assets/tiktok.jpg?raw=true)

![alt text](http://github.com/ugurtosun/SentimentAnalysisDataCollection/blob/master/assets/whatsapp.jpg?raw=true)

![alt text](http://github.com/ugurtosun/SentimentAnalysisDataCollection/blob/master/assets/facebook.jpg?raw=true)

![alt text](http://github.com/ugurtosun/SentimentAnalysisDataCollection/blob/master/assets/messenger.jpg?raw=true)

![alt text](http://github.com/ugurtosun/SentimentAnalysisDataCollection/blob/master/assets/hulu.jpg?raw=true)

![alt text](http://github.com/ugurtosun/SentimentAnalysisDataCollection/blob/master/assets/roblox.jpg?raw=true)

![alt text](http://github.com/ugurtosun/SentimentAnalysisDataCollection/blob/master/assets/spotify.jpg?raw=true)

![alt text](http://github.com/ugurtosun/SentimentAnalysisDataCollection/blob/master/assets/outlook.jpg?raw=true)

![alt text](http://github.com/ugurtosun/SentimentAnalysisDataCollection/blob/master/assets/googledocs.jpg?raw=true)

![alt text](http://github.com/ugurtosun/SentimentAnalysisDataCollection/blob/master/assets/googledrive.jpg?raw=true)

![alt text](http://github.com/ugurtosun/SentimentAnalysisDataCollection/blob/master/assets/ubereats.jpg?raw=true)

![alt text](http://github.com/ugurtosun/SentimentAnalysisDataCollection/blob/master/assets/wish.jpg?raw=true)

![alt text](http://github.com/ugurtosun/SentimentAnalysisDataCollection/blob/master/assets/googlemaps.jpg?raw=true)

### Results for application categories

![alt text](http://github.com/ugurtosun/SentimentAnalysisDataCollection/blob/master/assets/food&shopping.jpg?raw=true)

![alt text](http://github.com/ugurtosun/SentimentAnalysisDataCollection/blob/master/assets/photo&video.jpg?raw=true)

![alt text](http://github.com/ugurtosun/SentimentAnalysisDataCollection/blob/master/assets/productivity.jpg?raw=true)

![alt text](http://github.com/ugurtosun/SentimentAnalysisDataCollection/blob/master/assets/entertainment.jpg?raw=true)

![alt text](http://github.com/ugurtosun/SentimentAnalysisDataCollection/blob/master/assets/social-networking.jpg?raw=true)

