package uh.ac.cr.util;

import uh.ac.cr.manager.World;

import java.io.*;

public class FileManager {

    File file;
    FileWriter fileWriter;
    FileReader fileReader;

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

    public void load(String nameWorld, World world, OperationController operationController) throws FileNotFoundException {
        file = new File("src/uh/ac/cr/worlds", nameWorld + ".txt");

        readFile(file, world, operationController);
    }

    public void readFile(File file, World world, OperationController operationController) throws FileNotFoundException {
        fileReader = new FileReader(file);

        //TODO - Finish
    }
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
