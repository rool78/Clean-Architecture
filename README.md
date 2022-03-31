# Sample App using clean architecture


The idea of this repository is to practice Android Development following good practices such as Clean Architecture.


## Clean Architecture

Features are divided into three layers, presentation, domain and data:

* **Presentation:** This layer contains the user interface (Fragments) and they are
coordinated by a ViewModel that interacts with domain use cases.

* **Domain:** It is the deepest layer and has no dependency on any other layer, it
contains use cases, models and repository interfaces.

* **Data:** Contains the implementations of repositories and data sources.

![clean_architecture](https://user-images.githubusercontent.com/54546499/161149552-a18d9f0d-fb38-418e-b47b-fd1ec30e6a72.png)

## Stack

* Kotlin
* Clean Architecture
* MVVM
* LiveData
* Room
* Retrofit
* Dagger Hilt
