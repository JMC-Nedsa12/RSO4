mapi : 
java (strežnika)
openapi (oas3 definicija)

REST – API  (poenostavljen) definira:

- Strežnik, s katerim komuniciramo
- EndPoint-e (URI-je, ki jih lahko naslovimo)
- Parametre pri komunikaciji
- Podatkovne modele podatkov (ki jih vrača, jih dajemo kot parametre)
- Kdo/kda/do česa lahko dostopa (security)
- 	……



1.	Preskusi oba strežnika (http,https) op: oba bi morala delovati

- a)	http: ali se da nasloviti vse specificirane endpoint-e (path v oas3)
- b)	https enako kot http, vendar predhodno definirati certifikat:
uporabite pravo ime in priimek, Organization Unit=rso202x, O=VegovaLjubljana, city=ljubljana, coutryCode=SI (rso2020 v letu 2020, rso2021 v letu 2021, ...)
- c)	ali se da v javanski keystore uvoziti openssl generiran certifikat ali kako ? Podatki so kot pri zgonjem, le OU=rso202xOpenSSL


2.	Oba strežnika naj se odzivata na vse definirane endPoint 

Odziv naj bo demonstrativen (da se vidi, da URL-ji delujejo; glej primer http strežnika). Definirajte in usposobite manjkajoče endpointe na obeh strežnikih.

V pomoč:
editor.swagger.io  - lahko uvozite iz openapi.json/yaml -> v UI dobite izrisane vse endpoint-e in podatkovne modele
alternativno odprite v json v pametnem brskalniku ... ali pa end-point preberite iz izvorne kode programov
