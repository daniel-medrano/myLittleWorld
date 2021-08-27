package uh.ac.cr.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class FileManager {

    File file;
    FileWriter fileWriter;

    public FileManager() {
        file = null;
        fileWriter = null;
    }


    //People, vehicles, houses
    public boolean createWorld(String nameWorld) throws IOException {
        file = new File("src/uh/ac/cr/worlds", nameWorld + ".txt");
        if (!file.exists()) {
            return file.createNewFile();
        }
        return false;
    }

    public void save(String data) throws IOException {
        if (file != null) {
            fileWriter = new FileWriter(file);
            fileWriter.write(data);
            fileWriter.close();
        }
    }

    public void load(String nameWorld) throws Exception {
        file = new File("src/uh/ac/cr/worlds", nameWorld + ".txt");
        if (!file.exists()) {
            throw new Exception("\nERROR: The file doesn't exist.\n");
        }
    }

    public void writePeople() {

    }

    public void writeVehicles() {}

    /*
     *
     *"People": [
     *   "Doctor": {
     *       "id": value,
     *       "firstName": "value",
     *       "secondName": "value",
     *       "income": value,
     *       "sick": value,
     *       "dead": value,
     *       "specialization": "value"
     *   },
     *   "Carpenter": {
     *       "id": value,
     *       "firstName": "value",
     *       "secondName": "value",
     *       "income": value,
     *       "sick": value,
     *       "dead": value
     *   },
     *   "Chef": {
     *       "id": value,
     *       "firstName": "value",
     *       "secondName": "value",
     *       "income": value,
     *       "sick": value,
     *       "dead": value,
     *       "recipes": ["recipe1", "recipe2"]
     *   },
     *   "Blacksmith": {
     *       "id": value,
     *       "firstName": "value",
     *       "secondName": "value",
     *       "income": value,
     *       "sick": value,
     *       "dead": value,
     *   },
     *   "Builder": {
     *       "id": value,
     *       "firstName": "value",
     *       "secondName": "value",
     *       "income": value,
     *       "sick": value,
     *       "dead": value,
     *   }
     *]
     *
     * */


}
