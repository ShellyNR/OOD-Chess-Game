package Tools;

import java.util.HashMap;

public class common {

    public static HashMap<String, Tool> toolsCache;

    public common() {
        this.toolsCache = new HashMap<String, Tool>();
        toolsCache.put("KingW", new King(true));
        toolsCache.put("KingB", new King(false));
        toolsCache.put("QueenW", new Queen(true));
        toolsCache.put("QueenB", new Queen(false));
        toolsCache.put("RookW", new Rook(true));
        toolsCache.put("RookB", new Rook(false));
        toolsCache.put("BishopW", new Bishop(true));
        toolsCache.put("BishopB", new Bishop(false));
        toolsCache.put("KnightW", new Knight(true)); // is n in char[][]
        toolsCache.put("KnightB", new Knight(false));
        toolsCache.put("PawnW", new Pawn(true));
        toolsCache.put("PawnB", new Pawn(false));
        toolsCache.put("Empty", new EmptyTool(false));

    }


}
