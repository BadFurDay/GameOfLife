Conway's GAME OF LIFE 

Semesteroppgave i DATS1600 Programutvikling

@HiOA

by

Rudi André Dahle

Ginelle Zapanta Ignacio

Olav Magne Smevoll

----------------------------------------------------------

- Tip vindu gir brukeren kort info om hva som kan gjøres avhengig 
  av hvor i programmet man trykker.


- Cell color lar brukeren endre fargen til de levende cellene.


- Background color lar brukeren endre bakgrunnsfargen.


- Cell shape gjør det mulig å endre mellom to forskjellige visualiseringer 
  av de levende cellene. Rektangulær og sirkel.


- Speed slider endrer farten til spillet. For større brett anbefales lavere 
  fart for en bedre flyt av visualiseringen.


- Board size vinduet bytter foreløpig ikke den faktiskte brettstørrelsen, 
  men zoomer inn/ut til et teoretisk brett som viser antall celler valgt av brukeren. 
  ved valg av "board size" mindre enn den faktiske størrelsen vil den zoome inn 
  til nord-vest. 
  Ved valg av større brett vil det faktiske brettet være mindre enn det som 
  blir visualisert, og man vil ikke kunne legge til levende celler i 
  sør-øst delene som ikke eksisterer.
  Ved trykk på play knappen hopper man tilbake til det faktiske brettet.


- Clear knappen fjerner alle levende celler og setter brettstørrelsen 
  tilbake til den originale størrelsen (initialCells, Board klassen). 


- Grid slår grid linjene av og på. Hvis brettstørrelsen 
  overskrider 200x200 celler vil det slå seg av. 


- Play knappen starter og pauser spillet.


- Generations telleren viser brukeren hvor mange generasjoner som har kjørt.


- File -> Open File muliggjør innlasting av Game of Life mønster via .rle-filformatet.


- File -> Read Web File muliggjør innlasting av .rle filer direkte fra en URL.
		Problem: Mønsteret som skal lastes inn via URL kan ikke være 
			større enn det spillebrettet er ved innlastingstidspunkt.


- Help -> Guidelines inneholder spillereglene til Game of Life og info om de 
  forskjellige knappene og funksjonene til spillet.



OPPGAVER UTFØRT:
1. Planlegging:
	- Generell planlegging og forberedelser
	- Bruk av Git
	- UML diagram

2. Datastruktur:
	- Flerdimensjonale tabeller
	- Grafikk i javaFX (Ikke 3D)
	- Bruk av Singleton

3. Animasjon:
	- Animasjon i javaFX. (Timeline)

4. Testing:
	- JUnit testing
	- Dokumentering av kode via Javadoc
	- Ytelsesforbedring via nabosjekk

5. Filbehandling:
	- Exceptions brukt
	- Tolkning av GoL mønster (RLE)
	- Utvidelser, lesing fra web. (Funker ikke hvis mønstret krever større 
	  brett enn det eksisterende brettet ved lesing)

6. Tilegg:
	- Ingen av hovedoppgavene i tilleggsdokumentet, men vi har implementert 
	  manipulering via point-and-click interface på hovedspillebrettet

7. Dynamisk:
	- Dynamisk brett implementert

8. Samtidig:
	- Implementert tråder som kjører nextGeneration.


