package com.casino.controller;

import java.awt.print.Printable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casino.model.Game;
import com.casino.model.Play;
import com.casino.model.Player;
import com.casino.service.GameService;
import com.casino.service.PlayService;
import com.casino.service.PlayerService;

@RestController
@RequestMapping("/api/CasinoOnline")
public class CasinoController {

	@Autowired
	private PlayerService playerService;
	@Autowired
	private PlayService playService;
	@Autowired
	private GameService gameService;

	/**
	 * Método post para crear jugadores a través del body del gestor de la API.
	 * 
	 * @param player
	 * @return
	 */
	@PostMapping(value = "/createDataPlayer")
	public ResponseEntity<?> createDataPlayer(@RequestBody Player player) {
		return ResponseEntity.status(HttpStatus.CREATED).body(playerService.save(player));

	}

	/**
	 * Método post para crear diferentes tipos juegos a través del body del gestor
	 * de la API.
	 * 
	 * @param game
	 * @return
	 */
	@PostMapping(value = "/Game")
	public ResponseEntity<?> createGame(@RequestBody Game game) {
		return ResponseEntity.status(HttpStatus.CREATED).body(gameService.save(game));

	}

	/**
	 * Método para realizar una jugada, como parámetros :
	 * 
	 * @param playerId para saber que jugador realiza la apuesta
	 * @param gameType para saber que tipo de juego desea jugar al jugador
	 * @param playBet  para saber la apuesta que desea realizar el jugador
	 * @return
	 */
	@RequestMapping(value = "/Play/{playerId}/{gameType}/{playBet}", method = RequestMethod.POST)
	public ResponseEntity<?> makeAPlay(@PathVariable(value = "playerId") Long playerId,
			@PathVariable(value = "gameType") String gameType, @PathVariable(value = "playBet") Long playBet) {

		Optional<Player> player;
		Optional<Game> game;
		Integer increase = null;
		Play play = null;
		Long balanceBet;

		player = playerService.findById(playerId);
		balanceBet = player.get().getBalance() - playBet; // se calcula el balance del jugador con la apuesta a realizar
		
		game = gameService.findByGameType(gameType);
		

		if (balanceBet >= 0 ) { // si el balance es positivo, es decir, que el jugador tiene dinero suficiente
								// para realizar la apuesta

			if(game.get().getMaximumBet()>=playBet && playBet>=game.get().getMinimumBet()) {//si la apuesta está entre el máximo y el mínimo permitido por el juego
				
				gameService.gameTime(game); // simulamos el tiempo de juego según el tiempo del juego elegido

				if (gameService.isWinningPlay(game)) { // si el jugador gana

					playerService.increaseBalance(player, playBet); // se incrementa su balance en la apuesta que ha
																	// realizado
					increase = (int) +playBet;

				} else { // si el jugador pierde

					playerService.decreaseBalance(player, playBet); // se decrementa el balance del jugador
					increase = (int) -playBet;

				}

				play = playService.registerPlay(increase, playerId, gameType); // se registra la jugada
				return ResponseEntity.ok(play);
			}
			
			return ResponseEntity.ok("Debes realizar una apuesta entre "+game.get().getMinimumBet()+ " y " +game.get().getMaximumBet());


		} else { // en caso de que no pueda realizar la apuesta porque no tiene dinero

			return ResponseEntity.ok("No es posible realizar la jugada, jugador " + player.get().getId() + " "
					+ ".Esto es debido a que tu apuesta (" + playBet + ") es mayor que tu saldo actual ("
					+ player.get().getBalance() + ")."); // se devuelve la jugada vacía como signo de que no ha sido
															// posible realizarla
		}

	}

	/**
	 * Método para saber los detalles de una jugada a partir de su id
	 * 
	 * @param playId
	 * @return
	 */
	@RequestMapping(value = "/Get/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getPlay(@PathVariable(value = "id") Long playId) {

		Optional<Play> play = playService.findById(playId);

		if (!play.isPresent()) {
			return ResponseEntity.ok("La jugada " + playId + " no ha sido realizada.");
		}

		return ResponseEntity.ok(play);
	}

}
