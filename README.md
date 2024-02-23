# üK 223 #

## Multi User Applikation Backend

Hier wird Ihnen erklärt, wie Sie das Projekt starten und was Sie alles benötigen. Im Projekt muss man die Java JDK Version 18 benutzen. Ausserdem verwenden wir einen Docker-Container, der einen PostgreSQL-Server enthält. Der Docker läuft auf dem Port 5432. Im nächsten Schritt wird Ihnen der passende Command für das Erstellen des Docker bereitgestellt.

### Docker command
```
docker run --name postgres_db -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres
```

Wenn Sie den Standard-Benutzernamen "postgres" oder das Standardpasswort "postgres" ändern möchten, können Sie dies problemlos tun. Beachten Sie jedoch, dass die Änderungen auch in der Datei "application.properties" im Projekt vorgenommen werden müssen. 

### Users
Im Backendprojekt sind schon zwei Users vorhanden.
| User-Email         | Passwort | Role  |
|--------------------|----------|-------|
| admin@example.com  | 1234     | ADMIN |
| user@example.com   | 1234     | USER  |


Die Rechte sind so zugeteilt, dass der Admin alle Blogs lesen, bearbeiten und löschen kann, obwohl er die Blogs nicht seine sind. Der Admin kann eigene Blogs erstellen. Zusätzlich kann der Admin alle Benutzer anzeigen, bearbeiten und löschen.
<br>
Hingegen kann ein einfacher User einen Blog erstellen und den erstellten Blog auch bearbeiten und löschen. Der einfache Benutzer hat die Berechtigung, alle Blogs zu lesen, kann diese jedoch nicht verwalten, da er sie nicht erstellt hat.

### Git-Repository clonen

Um das Projekt erst zu benutzen, gibt es einen Command, den Sie ausführen können.
```
https://github.com/lorisdileo/ueK223_Backend_Gruppe2.git
```
Danach können Sie den zuvor installierten Docker laufen lassen. Öffnen Sie das Projekt in IntelliJ und runen Sie das Projekt.

### Troubleshooting

```
org.postgresql.util.PSQLException: ERROR: relation "role_authority" does not exist
```
Wenn dieser Fehler Auftritt, starten Sie einfach die Anwendung neu. Hibernate initialisiert die Tabellen manchmal nicht schnell genug und verursacht diesen Fehler. Ein Neustart der Anwendung behebt dies.