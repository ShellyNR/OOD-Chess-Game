package Tools;

import java.util.HashMap;

public class common {

    private static HashMap<EnumTool, Tool> toolsCache;
    private static common single_instance = null;

    private common() {
        this.toolsCache = new HashMap<EnumTool, Tool>();
        toolsCache.put(EnumTool.KingW, new King(true));
        toolsCache.put(EnumTool.KingB, new King(false));
        toolsCache.put(EnumTool.QueenW, new Queen(true));
        toolsCache.put(EnumTool.QueenB, new Queen(false));
        toolsCache.put(EnumTool.RookW, new Rook(true));
        toolsCache.put(EnumTool.RookB, new Rook(false));
        toolsCache.put(EnumTool.BishopW, new Bishop(true));
        toolsCache.put(EnumTool.BishopB, new Bishop(false));
        toolsCache.put(EnumTool.KnightW, new Knight(true)); // is n in char[][]
        toolsCache.put(EnumTool.KnightB, new Knight(false));
        toolsCache.put(EnumTool.PawnW, new Pawn(true));
        toolsCache.put(EnumTool.PawnB, new Pawn(false));
        toolsCache.put(EnumTool.Empty, new EmptyTool(false));

    }

    private static HashMap<EnumTool, Tool> getToolsCache() {
        return toolsCache;
    }

    public static HashMap<EnumTool, Tool> getInstance()
    {
        if (single_instance == null)
            single_instance = new common();

        return single_instance.getToolsCache();
    }



}
