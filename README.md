# devop_project
[![Maven Package](https://github.com/hacenesuper/devop_project/actions/workflows/github_action.yaml/badge.svg)](https://github.com/hacenesuper/devop_project/actions/workflows/github_action.yaml)
![Coverage](.github/badges/jacoco.svg)
![Branches](.github/badges/branches.svg)
[![GitHub forks](https://img.shields.io/github/forks/YoussefElkasri/Dataframe)](https://github.com/hacenesuper/devop_project/network)
![GitHub repo size](https://img.shields.io/github/repo-size/hacenesuper/devop_project)
![CodeFactor Grade](https://img.shields.io/codefactor/grade/github/hacenesuper/devop_project)
## auteur 
### <i> Amrane Hacene </i>

## Préambule
Les Dataframes sont des tableaux en deux dimensions où chaque colonne est identifiée par un label et chaque ligne par un index. Chaque colonne stocke des données d’un seul type. Cependant deux colonnes différentes peuvent stocker des types différents.  
Pandas est une des bibliotèques les plus populaires (pour langage Python). Elle permet de traiter de grandes quantités de données simplement et efficacement (plus d'informations sur https://pandas.pydata.org).   
L’objectif de ce projet est d'implémenter une sous-partie des fonctionnalitées offertes par Pandas en Java.

## Documentation : Javadoc
La documentation java de cette bibliothèque peut etre génerée en executant  à la racine du projet : 
```sh
mvn javadoc:javadoc
```
la doc se trouvera dans le repertoire target/site/apidocs.
## outils utiliser pour devloper la bibliotheque dataframe 
  <ul><li>Github : Pour le dépot distant </li>
  <li>Maven : pour automatiser les tâches de compilation, tests unitaires et déploiement des applications qui composent le projet </li>
  <li>Jacoco : pour le code coverage, qui se change automatiquement après chaque push dans la branche main </li>
  <li>JUnit 4.13: Pour les tests unitaires </li>
  <li>Docker hub : pour stocker les images de manière automatique à chaque fois qu'on fait un push dans la branche main </li>
  <li>GITWORKFLOW :  Pour l'integration continue </li>
  <li>OpenCSV  :  Pour simplifier la lecture des fichiers csv (plus d'info sur http://opencsv.sourceforge.net) </li>
  <li>Asciitable: Pour afficher proprement le dataframe sous forme de tableau (plus d'infos sur https://github.com/vdmeer/asciitable) </li></ul>
<li>CodeFactor  </li>

## Fonctionnalités de la bibliotheque 
## Création du dataframe
  <ul><li>A partir d'un fichier csv </li>
  <li>En entrant un tableau des données </li></ul>

## Affichage 
  <ul><li>Afficher les n derniers lignes </li>
  <li>Afficher les n premiers lignes </li>
   <li>Afficher les ligne entre deux nombre donner  </li></ul>

## Insertion de données
  <ul><li>Inserer une nouvelle ligne </li>
  <li>Inserer une nouvelle colonne </li></ul>

## fonction de stat
- Le minimum : `min(String)`
- Le maximum : `max(String)`
- La somme   : `sum(String)`
- La moyenne : `mean(String)`
applicables sur les colonnes numériques d'un Dataframe (Integer, Double ou Float). Ces fonctions prennent en parametre le nom d'une colonne: 

## Docker - DockerHub
Pour visiter le dépot dockerHub associé a ce projet : 
Pour récuperer l'image docker :
```sh
$ docker pull hacenesuper/dataframe:latest
```
Pour démarrer un conteneur correspondant à cette image docker :
```sh
$ docker run -it --rm hacenesuper/dataframe
```

## Execution
Pour lancer les tests unitaire, executer la commande suivante à la racine du projet :
```sh
$ mvn test
```
Pour lancer les tests unitaire et génerer le jar, executer la commande suivante à la racine du projet :
```sh
$ mvn package
```
Pour lancer le main de demonstration, executer ensuite  :
```sh
$ mvn exec:java -Dexec.args="src/main/test/ressources/test.csv"
```
## FeedBack