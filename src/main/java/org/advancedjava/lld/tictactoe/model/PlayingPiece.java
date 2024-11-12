package org.advancedjava.lld.tictactoe.model;

import lombok.Getter;

@Getter
public class PlayingPiece {

    private PieceType pieceType;

    public PlayingPiece(PieceType pieceType) {
        this.pieceType = pieceType;
    }
}
