# Proyecto-CallCenter-Java
Es un proyecto pensando en un software para Callcenter en el que se podrán identificar potenciales clientes del servicio de televisión por cable e internet de una empresa X.
El objetivo de la aplicación es poder incorporar el listado de “Contactos”, de los cuales tenemos la siguiente informacion:
• Nombre y Apellido: Valor alfanumérico.
• Celular: Compuesto del código de país + código de área + número de celular.
• E-Mail: Debe contener el símbolo ‘@’ y el caracter ‘.’.
• Dirección: Valor alfanumérico.
• Código Postal: Valor numérico.
• Localidad: Valor alfanumérico.
• Provincia. Enumerador que contenga las 23 provincias argentinas.
• Es cliente (Si o No): Inicialmente se carga en “No”.
• Desea ser llamado nuevamente (Si o No): Inicialmente se carga en “Si”.
Cuando el operador del callcenter ingresa a la aplicación, debe seleccionar “Realizar nueva llamada”. En ese momento el sistema debe “buscar un candidato” y mostrar por pantalla los datos de este. Para determinar qué contacto llamar, el sistema debe seleccionar aleatoriamente un contacto que cumpla con las siguientes condiciones:
1. El contacto NO debe ser cliente aún.
2. El contacto desea ser llamado o al menos no informó lo contrario.
3. El código postal del contacto debe existir en las zonas de cobertura existente.
Una vez que el operador realiza la llamada se debe poder registrar la misma:
a. Si la llamada fue exitosa (en ese caso el contacto pasa a ser cliente, y no se lo debe volver a llamar).
b. Si el contacto no desea ser llamado nuevamente (la llamada pudo no haber sido exitosa, pero se haga un nuevo intento en el futuro).
c. Observaciones: Texto libre donde el operador deja registro de lo conversado.

# Project-CallCenter-Java
It is a project thinking about a software for Callcenter in which potential clients of the cable television and internet service of a company X can be identified.
The objective of the application is to be able to incorporate the list of "Contacts", of which we have the following information:
• Name and Surname: Alphanumeric value.
• Cellular: Composed of the country code + area code + cell phone number.
• E-Mail: It must contain the symbol '@' and the character '.'.
• Address: Alphanumeric value.
• Postal Code: Numerical value.
• Locality: Alphanumeric value.
• Province. Enumerator containing the 23 Argentine provinces.
• Is a client (Yes or No): Initially it is loaded in “No”.
• Do you want to be called again (Yes or No): Initially it is loaded in “Yes”.
When the call center operator enters the application, they must select "Make a new call". At that time, the system must "search for a candidate" and display the candidate's data on the screen. To determine which contact to call, the system must randomly select a contact that meets the following conditions:
1. The contact must NOT be a customer yet.
2. The contact wants to be called or at least did not inform otherwise.
3. The zip code of the contact must exist in the existing coverage areas.
Once the operator makes the call, it should be possible to register it:
a. Whether the call was successful (in which case the contact becomes a customer, and should not be called back).
b. If the contact does not want to be called again (the call may not have been successful, but a new attempt will be made in the future).
c. Observations: Free text where the operator leaves a record of what was discussed.
