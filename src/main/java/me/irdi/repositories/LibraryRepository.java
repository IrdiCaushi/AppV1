package me.irdi.repositories;

import me.irdi.models.Library;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LibraryRepository extends MongoRepository <Library, String> {
    Library findBy_id(ObjectId _id);
}
