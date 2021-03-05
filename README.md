# Cours6-HttpRequest
HttpRequest with retrofit


Pour realiser des requests Http on utilise la library Retrofit

- On cree une classe retrofitHelper ou l'on va creer une instance de retrofit compose de:
 
 - Une instance de OkHttp qui est l'objet qui realise la request http (on peut le customiser, voire ci-dessous)
 - Le baseUrl soit l'url de notre API
 - Un converter pour convertir les texts de request body ou reponse body (en general en Json et donc convertit gravce a la library Gson) en objet Java que nous manipulons dans le code
 
- On cree une interface ApiService ou l'on declare nos requests qui sont compose de:

  - Une annotation indiquant la methode http de la request et la terminaison complementaire du baseUrl propre a cette request
  - La declaration de la fonction de request:
   - en parametre avec differentes annotations ce que l'on souhaite passer en path/query/requestBody/header a notre request
   - et son type de retour qui est un objet de type Call<T> soit l'objet qui represente la request et ou T est le type d'objet java correspondant au json du responseBody
   
- On retourne finalement dans retrofitHelper une instance de l'ApiService implement par retrofit avec retrofit.create(ApiService.class)

- On peut customiser le OkHttp en lui passant par exemple des interceptors qui permettent de realaliser des manipulations sur la request (independament de retrofit) et donc recevoir des informations plus primaire sur la request ou lui ajouter des parametres comme des headers de maniere systematique pour chacune des requests emise par notre instance de retrofit


ressources: doc de retrofit: https://square.github.io/retrofit/
