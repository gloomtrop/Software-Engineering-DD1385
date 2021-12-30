import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.tree.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LifeTree extends TreeFrame {

    static String file="../Life/TinyLife.txt";
    static Document dc;
    public static Map<String, String> map;
    static{map = new HashMap<>();}

    // Overrides method in TreeFrame

    void initTree(){
        root = new DefaultMutableTreeNode(dc.getDocumentElement().getAttribute("namn"));
        treeModel = new DefaultTreeModel( root );
        tree = new JTree( treeModel );
        buildTree();
    }

    private void buildTree(){
        Element node = dc.getDocumentElement();
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode =  nodeList.item(i);
            if (currentNode.getNodeType() == currentNode.ELEMENT_NODE){
                buildTree(currentNode, root);
            }
            if (currentNode.getNodeType() == currentNode.TEXT_NODE && !currentNode.getNodeValue().equals("\n")){
                String attrName = node.getAttribute("namn");
                String textString = node.getTagName() + ":"+ currentNode.getNodeValue();

                map.put(attrName, textString);
            }

        }
    }
    // New method
    private void buildTree(Node node, DefaultMutableTreeNode parent){
        //TO DO: Map tag name with respective name and text
        node.normalize();
        Element nodeElement = (Element) node;

        DefaultMutableTreeNode child = new DefaultMutableTreeNode(nodeElement.getAttribute("namn"));
        parent.add(child);

        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode =  nodeList.item(i);
            if (currentNode.getNodeType() == currentNode.ELEMENT_NODE){
                buildTree(currentNode, child);
            }
            if (currentNode.getNodeType() == currentNode.TEXT_NODE && !currentNode.getNodeValue().equals("\n")){
                String attrName = ((Element) node).getAttribute("namn");
                String textString = ((Element) node).getTagName() + ":"+ currentNode.getNodeValue();

                map.put(attrName, textString);
            }

        }
    }

    // New method

    // Overrides method in TreeFrame
    void showDetails(TreePath p){
        StringBuilder extra = new StringBuilder("Men allt som är ");
        if ( p == null )
            return;
        String tag = p.getLastPathComponent().toString();
        extra.append(tag);
//        System.out.println(p.getParentPath().toString());

        TreePath currentPath = p.getParentPath();
        for (int i = currentPath.getPathCount()-1; i>= 0; i--){
            extra.append(" är ").append(currentPath.getPathComponent(i).toString());

        }
        JOptionPane.showMessageDialog( this, map.get(tag) + extra);
    }

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

        if(args.length>0){
            file=args[0];
        }
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        dc = docBuilder.parse(new File(file));
        new LifeTree();
    }

}
