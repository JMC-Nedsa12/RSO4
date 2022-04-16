------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE:
PURPOSE OF PROJECT:
VERSION or DATE:
HOW TO START THIS PROJECT:
AUTHORS: Jan Trsan
USER INSTRUCTIONS:

----------------------------------------

Naloga 5: a) Zamenjava algoritma za hashiranje je preprosta..
Kot MessageDiggest argument podamo ime drugega algoritma.
Izvedba sha512 je na 64bit procesorjih hitrejša, kot sha256.
Čeprav naredi sha512 več passov, uporablja večje sklope podatkov in
lahko zato hitreje obdela večje datoteke, kot sha256. 
Obratno je na 32bit sistemih

        b) s hashom garantiramo integriteto datoteke. Če je datoteka
        po generiranju hasha spremenjena, se bo nov hash razlikoval od 
        prejšnjega in s tem bomo vedeli da se je datoteka spremenila.
        
        c) hash ni vgrajen v datoteko, saj bi ga lahko drugače napadalci
        spremenili po spreminjanju datoteka in zakrili svoje spremembe...
        Hash pa tudi ne more biti vgrajen v datoteko, saj je treba hash
        generirati preden ga lahko dodamo v datoteko. Če potem ta hash
        poskusimo vgraditi v datoteko, bi se nov hash datoteke spremenil...


