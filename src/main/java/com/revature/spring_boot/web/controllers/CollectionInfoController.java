package com.revature.spring_boot.web.controllers;
import com.revature.spring_boot.models.Account;
import com.revature.spring_boot.repos.CollectionInfoRepository;
import com.revature.spring_boot.services.CollectionInfoService;
import com.revature.spring_boot.web.dtos.AccountDTO;
import com.revature.spring_boot.web.dtos.CollectionInfoDTO;
import com.revature.spring_boot.web.security.JwtConfig;
import com.revature.spring_boot.web.security.TokenParser;
import com.revature.spring_boot.web.dtos.CollectionTypeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Controller class exposing user collection based endpoints
 */
@RestController
@RequestMapping("/collection")
public class CollectionInfoController {
    
    private Logger logger = LoggerFactory.getLogger(CollectionInfoController.class);

    private CollectionInfoService collectionInfoService;
    private TokenParser tokenParser;
    private CollectionInfoRepository collectionInfoRepository;

    @Autowired
    public CollectionInfoController(CollectionInfoService collectionInfoService, TokenParser tokenParser, CollectionInfoRepository collectionInfoRepository){
        this.collectionInfoService = collectionInfoService;
        this.tokenParser = tokenParser;
        this.collectionInfoRepository = collectionInfoRepository;

    }

    /**
     * Gets all existing user collections
     * @param req
     * @return
     */
    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/get-all")
    public List<CollectionInfoDTO> getAllCollections(HttpServletRequest req) {

        List<CollectionInfoDTO> collectionsInfo = collectionInfoService.getAllCollectionInfo()
                .stream()
                .map(CollectionInfoDTO::new)
                .collect(Collectors.toList());

        return collectionsInfo;
    }

    /**
     * Saves a new collection to the data layer when called
     * @param collectionInfo
     * @return
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE, value = "/save")
    @ResponseBody
    public CollectionInfoDTO saveNewCollectionInfo(@RequestBody @Valid CollectionInfoDTO collectionInfo){
//        System.out.println(collectionInfo.toString());
        CollectionInfoDTO savedCollectionInfo = new CollectionInfoDTO(collectionInfoService.saveCollectionInfo(collectionInfo));

        return savedCollectionInfo;
    }


 //   @GetMapping(value = "/getInfoById")

//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
//    public AppUserDTO registerNewUser(@RequestBody @Valid AppUser newUser, HttpServletResponse resp) {
//        AppUserDTO registeredUser = new AppUserDTO(userService.register(newUser));
//        resp.setHeader("Cache-Control", "no-store");
//        return registeredUser;
//    }

    /**
     * Gets a collection via id from the service layer when called
     * @param req
     * @return
     */
    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/get-info-by-id")
        public List<CollectionInfoDTO> getCollectionInfoByID(HttpServletRequest req){
        int accountID = tokenParser.tokenID(req);
        System.out.println(accountID);
        Account account = new Account();
        account.setId(accountID);
        
          List<CollectionInfoDTO> collectionInfo = collectionInfoRepository.findCollectionInfoByAccount_id(account)
                .stream()
                .map(CollectionInfoDTO::new)
                .collect(Collectors.toList());
          
        return collectionInfo;
    }

    /**
     * Delets a collection by id
     * @param collectionId
     */
    @DeleteMapping(value = "/delete/{collectionId}")
    public void deleteMovieCollection(@PathVariable(value = "collectionId") int collectionId) {

        collectionInfoService.deleteCollectionById(collectionId);

    }
}
