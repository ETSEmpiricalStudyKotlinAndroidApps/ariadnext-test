# Ariadnext_test
Application android qui simule un échange de messages client/serveur.

## Architecture
Dans ce projet, j'ai adopté la clean architecture qui est composée de:<br/>
Deux module:<br/>
-Client<br/>
  *Presentation. <br/>
-Server<br/>
  *Data.<br/>
  *Domain.<br/>

  ## Protocole d’échange
-Flow entre le client et le serveur.


## Libs
Pour l'injection de dépendances, j'ai utilisé "Hilt" :

```sh
     "com.google.dagger:hilt-android:2.41"
     "com.google.dagger:hilt-android-compiler:2.41"
```
Et les différents libs de base d'android :
```sh
     "com.google.android.material:material:1.5.0"
     "androidx.lifecycle:lifecycle-runtime-ktx:2.4.1"
     "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1"
     "androidx.activity:activity-ktx:2.4.1"
     "androidx.constraintlayout:constraintlayout:2.1.3"
     "androidx.core:core-ktx:1.7.0"
     "androidx.appcompat:appcompat:1.4.1"
     "com.google.android.material:material:1.5.0"

```



## Démonstration
Ce GIF présente une démonstration de l'application.

<img src="app/src/main/res/ariadnext_test.gif" alt="drawing" style="width:200px;"/>


## A améliorer/ ajouter
- Tests unitaires.
- Service en background pour le serveur.
- Ajout d'une base de donnée local "ROOM" pour sauvegarder l'historique des messages.
- Ajout de la couche domain et data pour le client.

## Temps de réalisation
- Lundi 11/04: 7h.



## License
TRABELSI mohamed safwen
**Free App**

