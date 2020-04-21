package org.antlr.jetbrains.st4plugin.highlight;

import com.intellij.codeHighlighting.TextEditorHighlightingPassFactoryRegistrar;
import com.intellij.codeHighlighting.TextEditorHighlightingPassRegistrar;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * This allows registering a {@link STGroupHighlightingPassFactory} in IntelliJ >= 2020.1.
 *
 * Factories registered via a project component don't work anymore, they have to be registered via the
 * dedicated EP. We keep both mechanism to provide compatibility with both older and newer versions of the IDEs.
 *
 * In older IDEs, the EP does not exist so this class will be ignored.
 * In newer IDEs, the EP will override what's done in the project component.
 */
public class STGroupHighlightingPassFactoryRegistrar implements TextEditorHighlightingPassFactoryRegistrar {
    @Override
    public void registerHighlightingPassFactory(@NotNull TextEditorHighlightingPassRegistrar registrar,
                                                @NotNull Project project) {
        new STGroupHighlightingPassFactory(project, registrar);
    }
}
