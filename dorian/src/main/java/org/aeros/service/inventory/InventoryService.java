package org.aeros.service.inventory;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class InventoryService {

    @Inject
    @ConfigProperty(name = "dorian.inventory-data")
    String inventoryFile;

    private final List<Item> stock = new ArrayList<>();

    public List<Item> getStock() {
        loadInventoryData();
        return stock;
    }

    private void loadInventoryData()  {
        Path filePath = Path.of(inventoryFile);
        var logger = System.getLogger(InventoryService.class.getName());

        logger.log(System.Logger.Level.INFO, "Reading inventory data from " + filePath.getFileName());
        if(!Files.exists(filePath))
            return;

        try(BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line = reader.readLine();
            while(true) {
                line = reader.readLine();
                if (line == null)
                    break;
                String[] split = line.split(",");
                stock.add(new Item(split[0], split[1], Integer.parseInt(split[2])));
            }
        }catch (Exception e) {e.printStackTrace();}
    }
}
