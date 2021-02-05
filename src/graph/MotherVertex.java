package graph;

/**
 * Let the last finished vertex be v. Basically, we need to prove that there cannot be an edge from another vertex u to
 * v if u is not another mother vertex (Or there cannot exist a non-mother vertex u such that u-→v is an edge). There can be two possibilities.
 *
 * Recursive DFS call is made for u before v. If an edge u-→v exists, then v must have finished before u because v
 * is reachable through u and a vertex finishes after all its descendants.
 * Recursive DFS call is made for v before u. In this case also, if an edge u-→v exists, then either v must finish
 * before u (which contradicts our assumption that v is finished at the end) OR u should be reachable from v
 * (which means u is another mother vertex).
 */
public class MotherVertex {

}
