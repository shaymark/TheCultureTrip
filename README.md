# TheCultureTrip

Di:
using hilt

Network:
using retrofit for network calls and json parse, return suspend function

Data flow:
using android viewmodel for fetch data and pass it to the ui
using corutines for fetching and liveData for pass result to the ui
result are passed with Resource item (loading, success, error)

Comunication between ui components:
open activity with intent and pass the data inside the intent

Recyclerview:
use listAdapter with diffutil

Showing images:
using the Glide library

UiLayout:
use constrain layout with styles in themes xml
