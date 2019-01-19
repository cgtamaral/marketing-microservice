package br.pucminas.marketingmicroservice.api.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucminas.marketingmicroservice.api.Response;
import br.pucminas.marketingmicroservice.api.dtos.MarketingDTO;
import br.pucminas.marketingmicroservice.api.entities.Marketing;
import br.pucminas.marketingmicroservice.api.services.MarketingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1/public")
@CrossOrigin(origins = "*")
@Api(value = "marketings", description = "Recurso para gerenciamento de anuncios", tags={ "marketings"})
public class MarketingController 
{
	private static final Logger log = LoggerFactory.getLogger(MarketingController.class);
	
	@Autowired
	private MarketingService marketingService;
	
	@ApiOperation(value = "Recupera todos os anuncios existentes", nickname = "findAllMarketings", notes = "", tags={ "marketings"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida!"),
		   				@ApiResponse(code = 404, message = "Nenhuma anuncio foi encontrado na base de dados!") })
	@GetMapping(value ="/marketings", produces = "application/json")
	public ResponseEntity<Response<List<MarketingDTO>>> findAllMarketings()
	{
		Response<List<MarketingDTO>> response = new Response<List<MarketingDTO>>();
		
		log.info("Consultando usuários existentes na base de dados!");
		List<Marketing> marketings = marketingService.findAll();

		if (marketings.isEmpty()) {
			log.info("Nenhum anuncio foi encontrado na base de dados!");
			response.getErrors().add("Nenhum usuário foi encontrado na base de dados!");
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}

		response.setData(Marketing.convertToDTO(marketings));
		
		return ResponseEntity.ok(response);
	}
	
	@ApiOperation(value = "Consulta dados de um anuncio especifico", nickname = "findMarketingsById", notes = "", tags={ "marketings"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Operação bem sucessida!"),
		    @ApiResponse(code = 404, message = "Não foi encontrado nenhum usuário")})
	@GetMapping(value = "/marketings/{marketingId}", produces = "application/json")
	public ResponseEntity<Response<MarketingDTO>> findMarketingsById(@ApiParam(value = "Identificador do anuncio a ser consultado", required = true) @PathVariable("marketingId") Long marketingId)
	{
		Response<MarketingDTO> response = new Response<MarketingDTO>();
		
		log.info("Consultando anuncio na base de dados: {} " +marketingId);
		Optional<Marketing> marketing = marketingService.findById(marketingId);
		

		if (!marketing.isPresent()) {
			log.info("Nenhum anuncio foi encontrado para o marketingId: {}" + marketingId);
			response.getErrors().add("Nenhum anuncio foi encontrado para o marketingId" + marketingId);
			
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(Marketing.convertToDTO(marketing.get()));
			
		return ResponseEntity.ok(response);
	}
	
}
